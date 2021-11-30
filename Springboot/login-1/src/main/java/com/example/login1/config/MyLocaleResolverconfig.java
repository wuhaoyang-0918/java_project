package com.example.login1.config;

import com.example.login1.component.MyLocaleResolver;

import com.example.login1.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 昊洋
 * @date:2020-07-14 15:26
 * @description: MyLocaleResolverconfig
 * @version: 1.0
 */
@Configuration
public class MyLocaleResolverconfig implements WebMvcConfigurer {
    /**
     * 国际化语言
     */
    @Bean
    public LocaleResolver localeResolver(){

        return new MyLocaleResolver();
    }
    /**
     * 注入拦截器
     */
    @Bean
    public LoginHandlerInterceptor loginHandlerInterceptor(){
        return new LoginHandlerInterceptor();
    }

    /**
     * 注册拦截器（方法拦截与放行）
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login","/asserts/**","/webjars/**");
    }
}
