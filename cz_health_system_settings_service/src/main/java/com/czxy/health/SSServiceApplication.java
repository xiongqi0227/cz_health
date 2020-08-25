package com.czxy.health;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by xiongqi.
 */
@SpringBootApplication
@EnableEurekaClient
public class SSServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SSServiceApplication.class,args);
    }
}
