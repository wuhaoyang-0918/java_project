package com.why.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author 昊洋
 * @date:2020-08-24 11:25
 * @PackageName: com.why.springcloud
 * @ClassName: ZuulApplication_9527
 * @description:
 * @version: 1.0
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication_9527 {
    public static void main(String[] args) {

        SpringApplication.run(ZuulApplication_9527.class,args);
    }
}
