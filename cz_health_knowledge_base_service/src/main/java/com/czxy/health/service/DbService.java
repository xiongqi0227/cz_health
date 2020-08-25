package com.czxy.health.service;

import com.czxy.health.domain.DiseaseBank;
import com.czxy.health.vo.QueryDb;
import com.github.pagehelper.PageInfo;

/**
 * Created by xiongqi.
 */
public interface DbService {
    /**
     * 分页条件查询疾病库
     *
     * @param queryDb
     * @return
     */
    PageInfo<DiseaseBank> findDbList(QueryDb queryDb);

    /**
     * 添加疾病
     *
     * @param diseaseBank
     * @return
     */
    int addDb(DiseaseBank diseaseBank);

    /**
     * 根据id查询疾病
     *
     * @param dbId
     * @return
     */
    DiseaseBank findDbById(Integer dbId);

    /**
     * 修改疾病
     *
     * @param diseaseBank
     * @return
     */
    int editDb(DiseaseBank diseaseBank);

    /**
     * 删除疾病
     *
     * @param dbId
     * @return
     */
    int deleteDb(Integer dbId);
}
