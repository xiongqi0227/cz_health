package com.czxy.health.repository;

import com.czxy.health.domain.User;
import com.czxy.health.vo.QueryUserVo;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by xiongqi.
 */
@org.apache.ibatis.annotations.Mapper
public interface UserRepository extends Mapper<User> {
    /**
     * 用户登录
     *
     * @param umUsername
     * @param umPassword
     * @return
     */

    User login(@Param("umUsername") String umUsername, @Param("umPassword") String umPassword);

    /**
     * 根据电话号码查询用户
     *
     * @param phone
     * @return
     */
    @Select("select * from user_management where um_phone = #{phone}")
    @ResultMap("u1")
    User findUserByPhone(@Param("phone") String phone);

    /**
     * 分页条件查询用户列表
     *
     * @param queryUserVo
     * @return
     */
    @Select("<script>" +
            "select * from user_management" +
            "<where>" +
            "<if test = \" umUsername!=null and umUsername!='' \"> and um_username like #{umUsername} </if>" +
            "<if test = \" umName!=null and umName!='' \"> and um_name = #{umName} </if>" +
            "</where>" +
            "</script>")
    @Results(id = "u1", value = {
            @Result(property = "umId", column = "um_id"),
            @Result(property = "umUsername", column = "um_username"),
            @Result(property = "umName", column = "um_name"),
            @Result(property = "umPassword", column = "um_password"),
            @Result(property = "umRole", column = "um_role"),
            @Result(property = "umPhone", column = "um_phone"),
            @Result(property = "umEmail", column = "um_email"),
            @Result(property = "umEnable", column = "um_enable"),
            @Result(property = "umCreateTime", column = "um_create_time"),
            @Result(property = "umLoginTimes", column = "um_login_times")
    })
    List<User> findUmList(QueryUserVo queryUserVo);
}
