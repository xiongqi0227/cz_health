package com.czxy.health.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.czxy.health.config.SmsUtil;
import com.czxy.health.vo.BaseResult;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiongqi.
 */
@RestController
@RequestMapping("/sms")
public class SmsController {

    @Resource
    private StringRedisTemplate redisTemplate;

    @PostMapping
    public BaseResult sendSms(String phone) {
        long start = System.currentTimeMillis();
        try {

            String code = RandomStringUtils.randomNumeric(4);
            redisTemplate.opsForValue().set("sms_register" + phone, code, 1, TimeUnit.HOURS);
            SendSmsResponse smsResponse = SmsUtil.sendSms(phone,code);
            if ("OK".equalsIgnoreCase(smsResponse.getCode())) {
                return BaseResult.ok("发送成功");
            } else {
                return BaseResult.error(smsResponse.getMessage());
            }
        } catch (Exception e) {
            long end = System.currentTimeMillis();
            System.out.println(end - start);
            return BaseResult.error("发送失败");
        }

    }
}
