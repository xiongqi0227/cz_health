package com.czxy.health.repository;

import com.czxy.health.domain.DiseaseBank;
import com.czxy.health.vo.QueryDb;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by xiongqi.
 */
@org.apache.ibatis.annotations.Mapper
public interface DbRepository extends Mapper<DiseaseBank> {
    /**
     * 分页条件查询疾病库
     *
     * @param queryDb
     * @return
     */
    @Select("<script>" +
            "select * from disease_bank" +
            "<where>" +
            "<if test = \" dbNumber !=null and dbNumber != ''\"> and db_number = #{dbNumber}</if>" +
            "<if test = \" dbName !=null and dbName != ''\"> and db_name like #{dbName}</if>" +
            "</where>" +
            "</script>")
    @Results(value = {
            @Result(property = "dbId", column = "db_id"),
            @Result(property = "dbNumber", column = "db_number"),
            @Result(property = "dbName", column = "db_name"),
            @Result(property = "dbExceptionType", column = "db_exception_type"),
            @Result(property = "dbOccupationalDiseases", column = "db_occupational_diseases"),
            @Result(property = "dbGender", column = "db_gender"),
            @Result(property = "dbTerm", column = "db_term"),
            @Result(property = "dbDepartment", column = "db_department"),
            @Result(property = "dbWarningLevel", column = "db_warning_level"),
            @Result(property = "dbOtherNames", column = "db_other_names"),
            @Result(property = "dbMedicalExplanation", column = "db_medical_explanation"),
            @Result(property = "dbCommonCauses", column = "db_common_causes"),
            @Result(property = "dbProposal", column = "db_proposal"),
            @Result(property = "dbCreateTime", column = "db_create_time")
    })
    List<DiseaseBank> findDbList(QueryDb queryDb);
}
