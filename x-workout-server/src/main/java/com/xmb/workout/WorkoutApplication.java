package com.xmb.workout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.TimeZone;

/**
 * @author Ben
 * @date 2020-04-21
 * @desc
 */
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.xmb.*"})
@EnableFeignClients(basePackages = "com.xmb.*")
public class WorkoutApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(WorkoutApplication.class, args);
    }
}
