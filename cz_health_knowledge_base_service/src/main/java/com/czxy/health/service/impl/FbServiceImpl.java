package com.czxy.health.service.impl;

import com.czxy.health.domain.FoodBank;
import com.czxy.health.repository.FbRepository;
import com.czxy.health.service.FbService;
import com.czxy.health.vo.QueryFb;
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
public class FbServiceImpl implements FbService {
    @Resource
    private FbRepository fbRepository;

    @Override
    public PageInfo<FoodBank> findFbList(QueryFb queryFb) {
        List<FoodBank> list = fbRepository.selectAll();
        for (FoodBank foodBank : list) {
            if (foodBank.getFbNumber() == null) {
                foodBank.setFbNumber("fb" + foodBank.getFbId());
                fbRepository.updateByPrimaryKey(foodBank);
            }
        }
        PageHelper.startPage(queryFb.getPageNum(), queryFb.getPageSize());
        if (queryFb.getFbName() != null && !"".equals(queryFb.getFbName())) {
            queryFb.setFbName("%" + queryFb.getFbName() + "%");
        }
        List<FoodBank> foodBankList = fbRepository.findFbList(queryFb);
        return new PageInfo<>(foodBankList);
    }

    @Override
    public int addFb(FoodBank foodBank) {
        Example example = new Example(FoodBank.class);
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("fbName",foodBank.getFbName());
        List<FoodBank> foodBankList = fbRepository.selectByExample(example);
        if (foodBankList!=null && foodBankList.size()!=0){
            return 0;
        }
        return fbRepository.insert(foodBank);
    }

    @Override
    public FoodBank findFbById(Integer fbId) {
        return fbRepository.selectByPrimaryKey(fbId);
    }

    @Override
    public int editFb(FoodBank foodBank) {
        return fbRepository.updateByPrimaryKey(foodBank);
    }

    @Override
    public int deleteFb(Integer fbId) {
        return fbRepository.deleteByPrimaryKey(fbId);
    }
}
