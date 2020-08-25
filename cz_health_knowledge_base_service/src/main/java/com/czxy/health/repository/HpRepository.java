package com.czxy.health.repository;

import com.czxy.health.domain.HealthProgramme;
import com.czxy.health.vo.QueryHp;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by xiongqi.
 */
@org.apache.ibatis.annotations.Mapper
public interface HpRepository extends Mapper<HealthProgramme> {
    /**
     * 分页条件查询健康方案列表
     *
     * @param queryHp
     * @return
     */
    @Select("<script>" +
            "select  * from health_programme" +
            "<where>" +
            "<if test=\" hpNumber!=null and hpNumber!='' \"> and hp_number = #{hpNumber} </if>" +
            "<if test=\" hpSchemeCategory!=null and hpSchemeCategory!='' \"> and hp_scheme_category = #{hpSchemeCategory} </if>" +
            "</where>" +
            "</script>")
    @Results(value = {
            @Result(property = "hpId", column = "hp_id"),
            @Result(property = "hpNumber", column = "hp_number"),
            @Result(property = "hpTitle", column = "hp_title"),
            @Result(property = "hpKeyWord", column = "hp_key_word"),
            @Result(property = "hpSchemeCategory", column = "hp_scheme_category"),
            @Result(property = "hpContent", column = "hp_content"),
            @Result(property = "hpRemarks", column = "hp_remarks"),
            @Result(property = "hpStatus", column = "hp_status")
    })
    List<HealthProgramme> findHpList(QueryHp queryHp);
}
