package com.czxy.health.service;

import com.czxy.health.domain.User;
import com.czxy.health.vo.QueryUserVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by xiongqi.
 */
public interface UserService {
    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 根据电话号码查询用户
     *
     * @param phone
     * @return
     */
    User findUserByPhone(String phone);

    /**
     * 修改密码
     *
     * @param user
     * @return
     */
    int editPassword(User user);

    /**
     * 根据id查询用户（远程调用）
     *
     * @param mpHealthManager
     * @return
     */
    User findAllUserById(Integer mpHealthManager);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAllUser();

    /**
     * 手机号码登录
     *
     * @param phone
     * @return
     */
    User phoneLogin(String phone);

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 分页条件查询用户列表
     *
     * @param queryUserVo
     * @return
     */
    PageInfo<User> findUmList(QueryUserVo queryUserVo);

    /**
     * 根据id查询用户
     *
     * @param umId
     * @return
     */
    User findUmById(Integer umId);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    int editUm(User user);

    /**
     * 删除用户
     *
     * @param umId
     * @return
     */
    int deleteUm(Integer umId);
}
