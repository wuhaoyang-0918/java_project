package com.example.cofig;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author why
 * @date 2021/10/25 15:09
 * @PackageName com.example.cofig
 * @description
 */
@EnableKnife4j
@EnableSwagger2
@Configuration
public class Swagger2Config {
    //访问地址:http://localhost:8080/doc.html#/home
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 标题
                .title("我的Swagger API文档")
                // 描述
                .description("使用Knife4j构建API文档")
                // 作者信息
                .contact(new Contact("why", "目前没有", "1648996479@163.com"))
                // 服务网址
                .termsOfServiceUrl("目前没有")
                // 版本
                .version("1.0.0")
                .build();
    }


}
