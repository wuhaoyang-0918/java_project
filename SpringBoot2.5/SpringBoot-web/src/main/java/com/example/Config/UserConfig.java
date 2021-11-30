package com.example.Config;

import com.example.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author why
 * @date 2021/10/26 9:40
 * @PackageName com.example.Config
 * @description   配置类也是一个组件使用(cglib代理)
 */
@Configuration  //proxyBeanMethods代理bean方法
public class UserConfig {

    /**
     * 外部无论调用多少次这个方法拿到都是注册容器单实例对象
     */
    @Bean("tom")   //没有指定bean id是方法名 指定@Bean("user")默认是单例
    public User user(){
        return new User();
    }
}
