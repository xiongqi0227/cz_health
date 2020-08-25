package com.czxy.health.service;

import com.czxy.health.domain.FoodBank;
import com.czxy.health.vo.QueryFb;
import com.github.pagehelper.PageInfo;

/**
 * Created by xiongqi.
 */
public interface FbService {
    /**
     * 分页查询膳食库列表
     * @param queryFb
     * @return
     */
    PageInfo<FoodBank> findFbList(QueryFb queryFb);

    /**
     * 添加食品
     * @param foodBank
     * @return
     */
    int addFb(FoodBank foodBank);

    /**
     * 根据id查询食品
     * @param fbId
     * @return
     */
    FoodBank findFbById(Integer fbId);

    /**
     * 修改食品
     * @param foodBank
     * @return
     */
    int editFb(FoodBank foodBank);

    /**
     * 删除食品
     * @param fbId
     * @return
     */
    int deleteFb(Integer fbId);
}
