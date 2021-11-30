package com.example.demoswg.config;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author 昊洋
 * @date:2020-07-20 9:02
 * @description: SwaggerConfig
 * @version: 1.0
 */
@Configuration
@EnableSwagger2  //开启Swagger2
public class SwaggerConfig {
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }
    @Bean
    public Docket docket(Environment environment) {
        //获得项目环境
       Profiles pro=Profiles.of("dev","test");
        boolean flag = environment.acceptsProfiles(pro);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("昊洋")
                .enable(true)//是否启动swagger ,false则游览器中访问不了
                .select()
                //RequestHandlerSelectors扫描接口的方式
                     //basePackage扫描指定包
                     //any()扫描全部
                    //none()都不扫描
                    //withclassAnnotation （GetMapping.class）扫描类上的注解 ,参数是一个注解的反射对象
                   //withMethodAnnotation
                .apis(RequestHandlerSelectors.basePackage("com.example.demoswg.controll"))
                //paths()过滤什么路径
                //.paths(PathSelectors.ant("/kuangshen/**"))
                .build();
    }
    //配置Swagger信息=ipiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact CONTACT = new Contact("昊洋", "1648996479@qq.com", "1648996479@qq.com");
        return  new ApiInfo(
                "昊洋的Swagger的API文档",
                "永无bug",
                "V1.0",
                "1648996479@qq.com",
                CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }
}

