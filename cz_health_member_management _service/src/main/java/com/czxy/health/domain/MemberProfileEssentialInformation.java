package com.czxy.health.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by xiongqi.
 * 会员档案（基本信息）
 */

@Table ( name ="member_profile_essential_information")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberProfileEssentialInformation  implements Serializable {

	/** 主键*/
	@Id
   	@Column(name = "mp_id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mpId;
	/** 档案号*/
   	@Column(name = "mp_file_number" )
	private String mpFileNumber;
	/** 身份证*/
   	@Column(name = "mp_id_card" )
	private String mpIdCard;
	/** 密码*/
   	@Column(name = "mp_password" )
	private String mpPassword;
	/** 手机号*/
   	@Column(name = "mp_phone" )
	private String mpPhone;
	/** 姓名*/
   	@Column(name = "mp_name" )
	private String mpName;
	/** 性别*/
   	@Column(name = "mp_gender" )
	private String mpGender;
	/** 民族*/
   	@Column(name = "mp_nation" )
	private String mpNation;
	/** 年龄*/
   	@Column(name = "mp_age" )
	private String mpAge;
	/** 出生日期*/
   	@Column(name = "mp_birthday" )
	private String mpBirthday;
	/** 注册时间*/
   	@Column(name = "mp_create_time" )
	private String mpCreateTime;
	/** 邮箱*/
   	@Column(name = "mp_email" )
	private String mpEmail;
	/** 婚姻状态*/
   	@Column(name = "mp_married" )
	private String mpMarried;
	/** 职业*/
   	@Column(name = "mp_occupation" )
	private String mpOccupation;
	/** 文化程度*/
   	@Column(name = "mp_degreeEducation" )
	private String mpDegreeEducation;
	/** 籍贯*/
   	@Column(name = "mp_native_place" )
	private String mpNativePlace;
	/** 健康管理师*/
   	@Column(name = "mp_health_manager" )
	private Integer mpHealthManager;
	/** 档案状态*/
   	@Column(name = "mp_file_status" )
	private Integer mpFileStatus;
	/** 备注*/
   	@Column(name = "mp_remarks" )
	private String mpRemarks;
	/** 对应的健康管理师*/
	private User user;
}
