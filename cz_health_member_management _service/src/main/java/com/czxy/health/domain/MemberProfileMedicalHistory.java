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
 * 会员档案（病史）
 */


@Table ( name ="member_profile_medical_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberProfileMedicalHistory  implements Serializable {
	/** 主键*/
	@Id
   	@Column(name = "mpmh_id" )
	private Integer mpmhId;
	/** 对应的会员*/
   	@Column(name = "mpmh_mpId" )
	private Integer mpmhMpId;
	/** 既往史*/
   	@Column(name = "mpmh_past_history" )
	private String mpmhPastHistory;
	/** 家族史*/
   	@Column(name = "mpmh_family_history" )
	private String mpmhFamilyHistory;
	/** 过敏史*/
   	@Column(name = "mpmh_allergy_history" )
	private String mpmhAllergyHistory;
	/** 病史*/
   	@Column(name = "mpmh_medical_history" )
	private String mpmhMedicalHistory;
	/** 慢性病*/
   	@Column(name = "mpmh_chronic_disease" )
	private String mpmhChronicDisease;


}
