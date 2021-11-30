package org.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author 昊洋
 * @date:2021-07-31 10:14
 * @PackageName: org.example.demo
 * @description:
 * @Version 1.0
 */
@Configuration
@PropertySource(value ={"classpath:config.properties"},encoding = "UTF-8")
public class Config1 {
   @Bean
    public School1 school1(){
        return  new School1();
    }
}
