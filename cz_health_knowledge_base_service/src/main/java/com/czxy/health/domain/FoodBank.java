package com.czxy.health.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by xiongqi.
 * 膳食库
 */
@Table(name = "food_bank")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FoodBank implements Serializable {
    /** 主键*/
    @Id
    @Column(name = "fb_id")
    private Integer fbId;
    /** 编码*/
    @Column(name = "fb_number")
    private String fbNumber;
    /** 食物名称*/
    @Column(name = "fb_name")
    private String fbName;
    /** 所属类别*/
    @Column(name = "fb_category")
    private String fbCategory;
    /** 每Kcal能量*/
    @Column(name = "fb_kcal_energy")
    private Integer fbKCalEnergy;
    /** 每KJ能量*/
    @Column(name = "fb_kj_energy")
    private Integer fbKjEnergy;
    /** 碳水化合物含量*/
    @Column(name = "fb_carbohydrate_content")
    private Integer fbCarbohydrateContent;
    /** 脂肪含量*/
    @Column(name = "fb_fat_content")
    private Integer fbFatContent;
    /** 蛋白质含量*/
    @Column(name = "fb_protein_content")
    private Integer fbProteinContent;
    /** 高血压*/
    @Column(name = "fb_hypertension")
    private Integer fbHypertension;
    /** 糖尿病*/
    @Column(name = "fb_diabetes")
    private Integer fbDiabetes;
    /** 冠心病*/
    @Column(name = "fb_coronary_heart_disease")
    private Integer fbCoronaryHeartDisease;
    /** 脑卒中*/
    @Column(name = "fb_cerebral_apoplexy")
    private Integer fbCerebralApoplexy;
    /** 心脑血管疾病*/
    @Column(name = "fb_cardiovascular_and_cerebrovascular_diseases")
    private Integer fbCardiovascularAndCerebrovascularDiseases;
    /** 高血脂*/
    @Column(name = "fb_hyperlipidemia")
    private Integer fbHyperlipidemia;
    /** 肥胖*/
    @Column(name = "fb_obesity")
    private Integer fbObesity;
    /** 痛风*/
    @Column(name = "fb_gout")
    private Integer fbGout;
    /** 说明*/
    @Column(name = "fb_explain")
    private String fbExplain;
}
