package com.example.cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author why
 * @date 2021/10/18 16:56
 * @PackageName com.example.cofig
 * @description
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/mvc").setViewName("index");
        registry.addViewController("/mvc1").setViewName("index1");
    }
    //  //所有的WebMvcConfigurer组件都会一起起作用
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {

        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/mvc2").setViewName("index2");
                registry.addViewController("/mvc3").setViewName("index3");
            }
        };
    }
}
