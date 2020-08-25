package com.czxy.health;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by xiongqi.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class HealthZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(HealthZuulApplication.class,args);
    }
}
