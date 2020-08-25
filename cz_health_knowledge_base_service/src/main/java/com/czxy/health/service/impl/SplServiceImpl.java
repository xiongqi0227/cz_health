package com.czxy.health.service.impl;

import com.czxy.health.domain.SportsProjectLibrary;
import com.czxy.health.repository.SplRepository;
import com.czxy.health.service.SplService;
import com.czxy.health.vo.QuerySpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiongqi.
 */
@Service
@Transactional
public class SplServiceImpl implements SplService {
    @Resource
    private SplRepository splRepository;

    @Override
    public PageInfo<SportsProjectLibrary> findSplList(QuerySpl querySpl) {
        List<SportsProjectLibrary> list = splRepository.selectAll();
        for (SportsProjectLibrary spl : list) {
            if (spl.getSplNumber()==null){
                spl.setSplNumber("spl"+spl.getSplId());
                splRepository.updateByPrimaryKeySelective(spl);
            }
        }
        PageHelper.startPage(querySpl.getPageNum(),querySpl.getPageSize());
        if (querySpl!=null && !"".equals(querySpl.getSplName())){
            querySpl.setSplName("%"+querySpl.getSplName()+"%");
        }
        List<SportsProjectLibrary> splList = splRepository.findSplList(querySpl);
        return new PageInfo<>(splList);
    }

    @Override
    public int addSpl(SportsProjectLibrary sportsProjectLibrary) {
        Example example = new Example(SportsProjectLibrary.class);
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("splName",sportsProjectLibrary.getSplName());
        List<SportsProjectLibrary> list = splRepository.selectByExample(example);
        if (list.size() != 0 && list != null){
            return 0;
        }
        sportsProjectLibrary.setSplAgeRange(sportsProjectLibrary.getMinAge()+"-"+sportsProjectLibrary.getMaxAge());
        return splRepository.insert(sportsProjectLibrary);
    }

    @Override
    public SportsProjectLibrary findSplById(Integer splId) {
        SportsProjectLibrary spl = splRepository.selectByPrimaryKey(splId);
        String[] split = spl.getSplAgeRange().split("-");
        spl.setMinAge(Integer.parseInt(split[0]));
        spl.setMaxAge(Integer.parseInt(split[1]));
        return spl;
    }

    @Override
    public int editSpl(SportsProjectLibrary sportsProjectLibrary) {
        sportsProjectLibrary.setSplAgeRange(sportsProjectLibrary.getMinAge()+"-"+sportsProjectLibrary.getMaxAge());
        return splRepository.updateByPrimaryKey(sportsProjectLibrary);
    }

    @Override
    public int deleteSpl(Integer splId) {
        return splRepository.deleteByPrimaryKey(splId);
    }
}
