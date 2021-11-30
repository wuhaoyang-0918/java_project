package com.why.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import javax.swing.*;
import java.util.Map;

/**
 * @author 昊洋
 * @date:2020-08-23 13:09
 * @PackageName: com.why.springcloud
 * @ClassName: DeptConsumerDashboard_9001
 * @description:
 * @version: 1.0
 */
 @SpringBootApplication
 @EnableHystrixDashboard //开启
public class DeptConsumerDashboard_9001 {
    public static void main(String[] args) {

        SpringApplication.run(DeptConsumerDashboard_9001.class,args);
    }
}
