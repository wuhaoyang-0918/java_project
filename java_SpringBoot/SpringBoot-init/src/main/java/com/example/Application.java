package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //来标注一个主程序类，说明这是一个SpringBoot应用
public class Application {
    /**
     *
     * @param args
     * @SpringBootConfiguration
     * @EnableAutoConfiguration
     * @ComponentScan   扫包范围是：启动类同级包或者子包
     *
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
