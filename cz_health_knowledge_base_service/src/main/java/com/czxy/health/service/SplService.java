package com.czxy.health.service;

import com.czxy.health.domain.SportsProjectLibrary;
import com.czxy.health.vo.QuerySpl;
import com.github.pagehelper.PageInfo;

/**
 * Created by xiongqi.
 */
public interface SplService {
    /**
     * 分页条件查询运动项目列表
     * @param querySpl
     * @return
     */
    PageInfo<SportsProjectLibrary> findSplList(QuerySpl querySpl);

    /**
     * 添加运动项目
     * @param sportsProjectLibrary
     * @return
     */
    int addSpl(SportsProjectLibrary sportsProjectLibrary);

    /**
     * 根据id查询运动项目
     * @param splId
     * @return
     */
    SportsProjectLibrary findSplById(Integer splId);

    /**
     * 修改运动项目
     * @param sportsProjectLibrary
     * @return
     */
    int editSpl(SportsProjectLibrary sportsProjectLibrary);

    /**
     * 删除运动项目
     * @param splId
     * @return
     */
    int deleteSpl(Integer splId);
}
