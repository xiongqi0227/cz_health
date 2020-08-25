package com.czxy.health.service.impl;

import com.czxy.health.domain.HealthProgramme;
import com.czxy.health.repository.HpRepository;
import com.czxy.health.service.HpService;
import com.czxy.health.vo.QueryHp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiongqi.
 */
@Service
@Transactional
public class HpServiceImpl implements HpService {
    @Resource
    private HpRepository hpRepository;

    @Override
    public PageInfo findHpList(QueryHp queryHp) {
        List<HealthProgramme> l = hpRepository.selectAll();
        for (HealthProgramme h : l) {
            if (h.getHpNumber()==null){
                h.setHpNumber("hp"+h.getHpId());
                hpRepository.updateByPrimaryKey(h);
            }
        }
        PageHelper.startPage(queryHp.getPageNum(), queryHp.getPageSize());
        List<HealthProgramme> list = hpRepository.findHpList(queryHp);
        return new PageInfo(list);
    }

    @Override
    public int addHp(HealthProgramme healthProgramme) {
        return hpRepository.insert(healthProgramme);
    }

    @Override
    public HealthProgramme findHpById(Integer hpId) {
        return hpRepository.selectByPrimaryKey(hpId);
    }

    @Override
    public int editHp(HealthProgramme healthProgramme) {
        return hpRepository.updateByPrimaryKey(healthProgramme);
    }

    @Override
    public int deleteHp(Integer hpId) {
        return hpRepository.deleteByPrimaryKey(hpId);
    }
}
