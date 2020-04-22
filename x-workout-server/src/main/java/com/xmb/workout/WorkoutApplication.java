package com.xmb.workout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Ben
 * @date 2020-04-21
 * @desc
 */
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.xmb.*"})
public class WorkoutApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkoutApplication.class, args);
    }
}
