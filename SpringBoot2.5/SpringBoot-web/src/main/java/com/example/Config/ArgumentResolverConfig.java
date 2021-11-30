package com.example.Config;

import com.example.Resolver.UserIdArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author why
 * @date 2021/10/23 14:11
 * @PackageName com.example.Config
 * @description
 */
@Configuration
//4.9 自定义参数解析
public class ArgumentResolverConfig implements WebMvcConfigurer {
    @Autowired
    private UserIdArgumentResolver argumentResolver;
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(argumentResolver);
    }
}
