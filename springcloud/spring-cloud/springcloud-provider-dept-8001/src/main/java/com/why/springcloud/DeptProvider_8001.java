package com.why.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.hystrix.contrib.sample.stream.HystrixConfigSseServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import javax.servlet.Servlet;
import javax.servlet.ServletRegistration;

/**
 * @author 昊洋
 * @date:2020-08-11 15:06
 * @description: DeptProvider_8001
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient  //服务启动后自动注册到eureka中!
@EnableDiscoveryClient //服务发现
public class DeptProvider_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8001.class,args);
    }

}
