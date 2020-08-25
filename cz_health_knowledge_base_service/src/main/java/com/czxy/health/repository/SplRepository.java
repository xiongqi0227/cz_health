package com.czxy.health.repository;

import com.czxy.health.domain.SportsProjectLibrary;
import com.czxy.health.vo.QuerySpl;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by xiongqi.
 */
@org.apache.ibatis.annotations.Mapper
public interface SplRepository extends Mapper<SportsProjectLibrary> {
    /**
     * 分页条件查询运动项目列表
     * @param querySpl
     * @return
     */
    @Select("<script>" +
            "select * from sports_project_library" +
            "<where>" +
            "<if test=\" splNumber !=null and splNumber!= ''\"> spl_number = #{splNumber} </if>"+
            "<if test=\" splName !=null and splName!= ''\"> spl_name like #{splName} </if>"+
            "</where>"+
            "</script>")
    @Results(value = {
            @Result(property = "splId",column = "spl_id"),
            @Result(property = "splNumber",column = "spl_number"),
            @Result(property = "splName",column = "spl_name"),
            @Result(property = "splExerciseIntensity",column = "spl_exercise_intensity"),
            @Result(property = "splExerciseTime",column = "spl_exercise_time"),
            @Result(property = "splApplicableGender",column = "spl_applicable_gender"),
            @Result(property = "splAgeRange",column = "spl_age_range"),
            @Result(property = "splKiloStepEquivalent",column = "spl_kilostep_equivalent"),
            @Result(property = "splStretchingPart",column = "spl_stretching_part"),
            @Result(property = "splActionMethod",column = "spl_action_method"),
            @Result(property = "splMattersNeedingAttention",column = "spl_matters_needing_attention")
    })
    List<SportsProjectLibrary> findSplList(QuerySpl querySpl);
}
