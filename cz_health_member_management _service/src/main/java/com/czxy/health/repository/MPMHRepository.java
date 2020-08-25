package com.czxy.health.repository;

import com.czxy.health.domain.MemberProfileMedicalHistory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by xiongqi.
 */
@org.apache.ibatis.annotations.Mapper
public interface MPMHRepository extends Mapper<MemberProfileMedicalHistory> {
    /**
     * 根据id删除病史
     *
     * @param mpId
     * @return
     */
    @Delete("delete from member_profile_medical_history where mpmh_mpId = #{mpId}")
    int deleteMpmhById(@Param("mpId") Integer mpId);
}
