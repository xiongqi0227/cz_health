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
 * 用户管理
 */
@Table(name = "user_management")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {
    /** 主键*/
    @Id
    @Column(name = "um_id")
    private Integer umId;
    /** 用户名*/
    @Column(name = "um_username")
    private String umUsername;
    /** 真实姓名*/
    @Column(name = "um_name")
    private String umName;
    /** 密码*/
    @Column(name = "um_password")
    private String umPassword;
    /** 角色*/
    @Column(name = "um_role")
    private String umRole;
    /** 联系电话*/
    @Column(name = "um_phone")
    private String umPhone;
    /** 邮箱*/
    @Column(name = "um_email")
    private String umEmail;
    /** 是否启用*/
    @Column(name = "um_enable")
    private String umEnable;
    /** 添加时间*/
    @Column(name = "um_create_time")
    private String umCreateTime;
    /** 登录次数*/
    @Column(name = "um_login_times")
    private Integer umLoginTimes;
    /** 验证码*/
    @Transient
    private String code;
    /** 修改密码*/
    @Transient
    private String editPassword;
    /** 确认密码*/
    @Transient
    private String umConfirmPassword;
}
