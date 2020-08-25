package com.czxy.health.controller;

import com.czxy.health.domain.User;
import com.czxy.health.service.UserService;
import com.czxy.health.vo.BaseResult;
import com.czxy.health.vo.PhoneVo;
import com.czxy.health.vo.QueryUserVo;
import com.github.pagehelper.PageInfo;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiongqi.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @PostMapping("/userLogin")
    public BaseResult login(@RequestBody User user) {
        String redisCode = stringRedisTemplate.opsForValue().get("login" + user.getUmUsername());
        if (redisCode == null) {
            return BaseResult.error("验证码无效");
        }
        if (!redisCode.equalsIgnoreCase(user.getCode())) {
            return BaseResult.error("验证码错误");
        }
        stringRedisTemplate.delete("login" + user.getUmUsername());
        User loginUser = userService.login(user);
        if (loginUser != null) {
            return BaseResult.ok("登录成功").append("loginUser", loginUser);
        } else {
            return BaseResult.error("用户名或密码错误");
        }
    }

    /**
     * 根据电话号码查询用户
     *
     * @param phone
     * @return
     */
    @PostMapping("/findUserByPhone")
    public BaseResult findUserByPhone(String phone) {
        User user = userService.findUserByPhone(phone);
        if (user != null) {
            return BaseResult.ok("查询成功", user);
        } else {
            return BaseResult.error("电话号码未注册用户！");
        }
    }

    /**
     * 修改密码
     *
     * @param user
     * @return
     */
    @PostMapping("/editPassword")
    public BaseResult editPassword(@RequestBody User user) {
        int result = userService.editPassword(user);
        return result == 1 ? BaseResult.ok("修改成功") : BaseResult.error("修改失败");
    }

    /**
     * 根据id查询用户（远程调用）
     *
     * @param mpHealthManager
     * @return
     */
    @GetMapping("/findAllUserById/{mpHealthManager}")
    public BaseResult<User> findAllUserById(@PathVariable(name = "mpHealthManager") Integer mpHealthManager) {
        User user = userService.findAllUserById(mpHealthManager);
        return BaseResult.ok("查询成功", user);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @GetMapping("/findAllUser")
    public BaseResult<User> findAllUser() {
        List<User> list = userService.findAllUser();
        return BaseResult.ok("查询成功", list);
    }

    /**
     * 手机号码登录
     *
     * @param phoneVo
     * @return
     */
    @PostMapping("/phoneLogin")
    public BaseResult phoneLogin(@RequestBody PhoneVo phoneVo) {
        //验证码
        String code = stringRedisTemplate.opsForValue().get("sms_register" + phoneVo.getUmPhone());
        if (code == null) {
            return BaseResult.error("验证码失效");
        }
        if (!code.equals(phoneVo.getUmSmsCode())) {
            return BaseResult.error("验证码不正确");
        }
        //删除redis中的验证码
        stringRedisTemplate.delete("sms_register" + phoneVo.getUmPhone());
        User user = userService.phoneLogin(phoneVo.getUmPhone());
        return user != null ? BaseResult.ok("登录成功").append("loginUser", user) : BaseResult.error("手机号码不存在");
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
    public BaseResult register(@RequestBody User user) {
        int result = userService.register(user);
        return result == 1 ? BaseResult.ok("注册成功") : BaseResult.error("用户名已被注册");
    }

    /**
     * 分页条件查询用户列表
     *
     * @param queryUserVo
     * @return
     */
    @PostMapping("/findUmList")
    public BaseResult findUmList(@RequestBody QueryUserVo queryUserVo) {
        PageInfo<User> pageInfo = userService.findUmList(queryUserVo);
        return pageInfo != null ? BaseResult.ok("查询成功", pageInfo) : BaseResult.error("查询失败");
    }

    /**
     * 根据id查询用户
     *
     * @param umId
     * @return
     */
    @GetMapping("/findUmById/{umId}")
    public BaseResult findUmById(@PathVariable(name = "umId") Integer umId) {
        User user = userService.findUmById(umId);
        return user != null ? BaseResult.ok("查询成功", user) : BaseResult.error("查询失败");
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @PutMapping
    public BaseResult editUm(@RequestBody User user) {
        int result = userService.editUm(user);
        return result == 1 ? BaseResult.ok("修改成功") : BaseResult.error("修改失败");
    }

    /**
     * 删除用户
     *
     * @param umId
     * @return
     */
    @DeleteMapping("/{umId}")
    public BaseResult deleteUm(@PathVariable(name = "umId") Integer umId) {
        int result = userService.deleteUm(umId);
        return result == 1 ? BaseResult.ok("删除成功") : BaseResult.error("删除失败");
    }
  
}
