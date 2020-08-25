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
 * 健康方案
 */
@Table(name = "health_programme")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HealthProgramme implements Serializable {
    /** 主键*/
    @Id
    @Column(name = "hp_id")
    private Integer hpId;
    /** 编号*/
    @Column(name = "hp_number")
    private String hpNumber;
    /** 方案标题*/
    @Column(name = "hp_title")
    private String hpTitle;
    /** 关键词*/
    @Column(name = "hp_key_word")
    private String hpKeyWord;
    /** 方案类别*/
    @Column(name = "hp_scheme_category")
    private String hpSchemeCategory;
    /** 内容*/
    @Column(name = "hp_content")
    private String hpContent;
    /** 备注*/
    @Column(name = "hp_remarks")
    private String hpRemarks;
    /** 状态*/
    @Column(name = "hp_status")
    private Integer hpStatus;
}
