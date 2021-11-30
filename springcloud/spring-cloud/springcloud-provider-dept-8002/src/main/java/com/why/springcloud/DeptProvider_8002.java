package com.why.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 昊洋
 * @date:2020-08-11 15:06
 * @description: DeptProvider_8001
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient  //服务启动后自动注册到eureka中!
@EnableDiscoveryClient //服务发现
public class DeptProvider_8002 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8002.class,args);
    }


}
