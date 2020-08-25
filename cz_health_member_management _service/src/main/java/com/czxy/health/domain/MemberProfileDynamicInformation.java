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
 * 会员档案（动态信息）
 */


@Table ( name ="member_profile_dynamic_information")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberProfileDynamicInformation  implements Serializable {

	/** 主键*/
	@Id
   	@Column(name = "mpdi_id" )
	private Integer mpdiId;
	/** 对应的会员*/
   	@Column(name = "mpdi_mpId" )
	private Integer mpdiMpId;
	/** 身高*/
   	@Column(name = "mpdi_height" )
	private Integer mpdiHeight;
	/** 体重*/
   	@Column(name = "mpdi_weight" )
	private Integer mpdiWeight;
	/** 舒张压*/
   	@Column(name = "mpdi_diastolic_pressure" )
	private Integer mpdiDiastolicPressure;
	/** 收缩压*/
   	@Column(name = "mpdi_systolic_pressure" )
	private Integer mpdiSystolicPressure;
	/** 呼吸*/
   	@Column(name = "mpdi_breathing" )
	private Integer mpdiBreathing;
	/** 体温*/
   	@Column(name = "mpdi_temperature" )
	private Integer mpdiTemperature;
	/** 腰围*/
   	@Column(name = "mpdi_waist" )
	private Integer mpdiWaist;
	/** 臀围*/
   	@Column(name = "mpdi_hipline" )
	private Integer mpdiHipline;
	/** BMI*/
   	@Column(name = "mpdi_BMI" )
	private Integer mpdiBmi;
	/** 血氧饱和度*/
   	@Column(name = "mpdi_blood_oxygen_saturation" )
	private Integer mpdiBloodOxygenSaturation;


}
