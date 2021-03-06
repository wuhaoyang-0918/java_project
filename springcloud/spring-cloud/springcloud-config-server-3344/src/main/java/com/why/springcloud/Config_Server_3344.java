package com.why.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author 昊洋
 * @date:2020-08-24 13:38
 * @PackageName: com.why.springcloud
 * @ClassName: Config_Server_3344
 * @description:
 * @version: 1.0
 */
@SpringBootApplication
@EnableConfigServer
public class Config_Server_3344 {
    public static void main(String[] args) {
        SpringApplication.run(Config_Server_3344.class,args);
    }
}
