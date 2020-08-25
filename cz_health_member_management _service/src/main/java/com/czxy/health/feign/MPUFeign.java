package com.czxy.health.feign;

import com.czxy.health.domain.User;
import com.czxy.health.vo.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by findAllUserByIdxiongqi.
 */
@FeignClient(value = "ssservice", path = "/user")
public interface MPUFeign {
    /**
     * 根据id查询用户（远程调用）
     *
     * @param mpHealthManager
     * @return
     */
    @GetMapping("/findAllUserById/{mpHealthManager}")
    public BaseResult<User> findAllUserById(@PathVariable(name = "mpHealthManager") Integer mpHealthManager);

    /**
     * 查询所有用户
     *
     * @return
     */
    @GetMapping("/findAllUser")
    public BaseResult<User> findAllUser();
}
