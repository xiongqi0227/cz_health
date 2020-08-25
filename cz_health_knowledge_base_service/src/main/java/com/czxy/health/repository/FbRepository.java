package com.czxy.health.repository;

import com.czxy.health.domain.FoodBank;
import com.czxy.health.vo.QueryFb;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by xiongqi.
 */
@org.apache.ibatis.annotations.Mapper
public interface FbRepository extends Mapper<FoodBank> {
    /**
     * 分页查询膳食库列表
     * @param queryFb
     * @return
     */
    @Select("<script>" +
            "select * from food_bank" +
            "<where>" +
            "<if test=\" fbNumber!=null and fbNumber!='' \"> fb_number = #{fbNumber} </if>"+
            "<if test=\" fbName!=null and fbName!='' \"> fb_name like #{fbName} </if>"+
            "</where>"+
            "</script>")
    @Results(value = {
            @Result(property = "fbId",column = "fb_id"),
            @Result(property = "fbNumber",column = "fb_number"),
            @Result(property = "fbName",column = "fb_name"),
            @Result(property = "fbCategory",column = "fb_category"),
            @Result(property = "fbKCalEnergy",column = "fb_kcal_energy"),
            @Result(property = "fbKjEnergy",column = "fb_kj_energy"),
            @Result(property = "fbCarbohydrateContent",column = "fb_carbohydrate_content"),
            @Result(property = "fbFatContent",column = "fb_fat_content"),
            @Result(property = "fbProteinContent",column = "fb_protein_content"),
            @Result(property = "fbHypertension",column = "fb_hypertension"),
            @Result(property = "fbDiabetes",column = "fb_diabetes"),
            @Result(property = "fbCoronaryHeartDisease",column = "fb_coronary_heart_disease"),
            @Result(property = "fbCerebralApoplexy",column = "fb_cerebral_apoplexy"),
            @Result(property = "fbCardiovascularAndCerebrovascularDiseases",column = "fb_cardiovascular_and_cerebrovascular_diseases"),
            @Result(property = "fbHyperlipidemia",column = "fb_hyperlipidemia"),
            @Result(property = "fbObesity",column = "fb_obesity"),
            @Result(property = "fbGout",column = "fb_gout"),
            @Result(property = "fbExplain",column = "fb_explain")
    })
    List<FoodBank> findFbList(QueryFb queryFb);
}
