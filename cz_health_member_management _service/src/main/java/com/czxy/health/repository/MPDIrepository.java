package com.czxy.health.repository;

import com.czxy.health.domain.MemberProfileDynamicInformation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by xiongqi.
 */
@org.apache.ibatis.annotations.Mapper
public interface MPDIrepository extends Mapper<MemberProfileDynamicInformation> {
    /**
     * 根据档案id删除动态信息
     *
     * @param mpId
     * @return
     */
    @Delete("delete from member_profile_dynamic_information where mpdi_mpId = #{mpId}")
    int deleteMpdiById(@Param("mpId") Integer mpId);
}
