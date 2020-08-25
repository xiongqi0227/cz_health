package com.czxy.health.repository;

import com.czxy.health.domain.MemberProfileEssentialInformation;
import com.czxy.health.vo.MPVo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by xiongqi.
 */
@org.apache.ibatis.annotations.Mapper
public interface MPEIRepository extends Mapper<MemberProfileEssentialInformation> {
    /**
     * 分页条件查询会员列表
     * @param mpVo
     * @return
     */
    @Select("<script>" +
            "select * from member_profile_essential_information" +
            "<where>" +
            "<if test=\" mpFileNumber!=null and mpFileNumber!= ''\"> and mp_file_number = #{mpFileNumber} </if>"+
            "</where>"+
            "</script>")
    @Results(value = {
            @Result(property = "mpId",column = "mp_id"),
            @Result(property = "mpFileNumber",column = "mp_file_number"),
            @Result(property = "mpIdCard",column = "mp_id_card"),
            @Result(property = "mpPassword",column = "mp_password"),
            @Result(property = "mpPhone",column = "mp_phone"),
            @Result(property = "mpName",column = "mp_name"),
            @Result(property = "mpGender",column = "mp_gender"),
            @Result(property = "mpNation",column = "mp_nation"),
            @Result(property = "mpAge",column = "mp_age"),
            @Result(property = "mpBirthday",column = "mp_birthday"),
            @Result(property = "mpCreateTime",column = "mp_create_time"),
            @Result(property = "mpEmail",column = "mp_email"),
            @Result(property = "mpMarried",column = "mp_married"),
            @Result(property = "mpOccupation",column = "mp_occupation"),
            @Result(property = "mpDegreeEducation",column = "mp_degreeEducation"),
            @Result(property = "mpNativePlace",column = "mp_native_place"),
            @Result(property = "mpHealthManager",column = "mp_health_manager"),
            @Result(property = "mpFileStatus",column = "mp_file_status"),
            @Result(property = "mpRemarks",column = "mp_remarks")
    })
    List<MemberProfileEssentialInformation> findMPList(MPVo mpVo);
}
