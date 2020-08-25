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
 * 疾病库
 */
@Table(name = "disease_bank")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DiseaseBank implements Serializable {
    /** 主键*/
    @Id
    @Column(name = "db_id")
    private Integer dbId;
    /** 编码*/
    @Column(name = "db_number")
    private String dbNumber;
    /** 疾病名称*/
    @Column(name = "db_name")
    private String dbName;
    /** 异常类型*/
    @Column(name = "db_exception_type")
    private String dbExceptionType;
    /** 是否职业病*/
    @Column(name = "db_occupational_diseases")
    private String dbOccupationalDiseases;
    /** 适用性别*/
    @Column(name = "db_gender")
    private String dbGender;
    /** 就医期限*/
    @Column(name = "db_term")
    private String dbTerm;
    /** 就诊科室*/
    @Column(name = "db_department")
    private String dbDepartment;
    /** 预警等级*/
    @Column(name = "db_warning_level")
    private String dbWarningLevel;
    /** 其他名称*/
    @Column(name = "db_other_names")
    private String dbOtherNames;
    /** 医学解释*/
    @Column(name = "db_medical_explanation")
    private String dbMedicalExplanation;
    /** 常见原因*/
    @Column(name = "db_common_causes")
    private String dbCommonCauses;
    /** 建议*/
    @Column(name = "db_proposal")
    private String dbProposal;
    /** 创建时间*/
    @Column(name = "db_create_time")
    private String dbCreateTime;
}
