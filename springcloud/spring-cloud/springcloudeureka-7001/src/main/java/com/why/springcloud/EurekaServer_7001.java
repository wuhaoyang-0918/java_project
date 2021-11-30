package com.why.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import sun.applet.Main;

/**
 * @author 昊洋
 * @date:2020-08-11 23:15
 * @description: EurekaServer_7001
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaServer    //EnableEurekaServer服务端的启动类，可以接受别人注册进来
public class EurekaServer_7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7001.class,args);
    }
}
