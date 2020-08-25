package com.czxy.health;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by xiongqi.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MMServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MMServiceApplication.class,args);
    }
}
