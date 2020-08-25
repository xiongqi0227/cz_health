package com.czxy.health.service;

import com.czxy.health.domain.HealthProgramme;
import com.czxy.health.vo.QueryHp;
import com.github.pagehelper.PageInfo;

/**
 * Created by xiongqi.
 */
public interface HpService {
    /**
     * 分页条件查询健康方案列表
     *
     * @param queryHp
     * @return
     */
    PageInfo findHpList(QueryHp queryHp);

    /**
     * 添加健康方案
     *
     * @param healthProgramme
     * @return
     */
    int addHp(HealthProgramme healthProgramme);

    /**
     * 根据id查询健康方案
     *
     * @param hpId
     * @return
     */
    HealthProgramme findHpById(Integer hpId);

    /**
     * 修改健康方案
     *
     * @param healthProgramme
     * @return
     */
    int editHp(HealthProgramme healthProgramme);

    /**
     * 删除健康方案
     *
     * @param hpId
     * @return
     */
    int deleteHp(Integer hpId);
}
