package com.czxy.health.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by xiongqi.
 * 运动项目库
 */
@Table(name = "sports_project_library")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SportsProjectLibrary implements Serializable {
    /** 主键*/
    @Id
    @Column(name = "spl_id")
    private Integer splId;
    /** 编码*/
    @Column(name = "spl_number")
    private String splNumber;
    /** 项目名称*/
    @Column(name = "spl_name")
    private String splName;
    /** 运动强度*/
    @Column(name = "spl_exercise_intensity")
    private String splExerciseIntensity;
    /** 运动时间*/
    @Column(name = "spl_exercise_time")
    private Integer splExerciseTime;
    /** 适用性别*/
    @Column(name = "spl_applicable_gender")
    private String splApplicableGender;
    /** 年龄区间*/
    @Column(name = "spl_age_range")
    private String splAgeRange;
    /** 年龄下限*/
    @Transient
    private Integer minAge;
    /** 年龄上限*/
    @Transient
    private Integer maxAge;
    /** 千步当量*/
    @Column(name = "spl_kilostep_equivalent")
    private Integer splKiloStepEquivalent;
    /** 拉伸部位*/
    @Column(name = "spl_stretching_part")
    private String splStretchingPart;
    /** 动作方法*/
    @Column(name = "spl_action_method")
    private String splActionMethod;
    /** 注意事项*/
    @Column(name = "spl_matters_needing_attention")
    private String splMattersNeedingAttention;

}
