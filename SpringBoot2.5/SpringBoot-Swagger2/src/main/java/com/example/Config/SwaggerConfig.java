package com.example.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author why
 * @date 2021/10/25 16:03
 * @PackageName com.example.Config
 * @description
 */
@Configuration
@EnableSwagger2//开启Swagger2
public class SwaggerConfig {
    ////访问地址:http://localhost:8080/doc.html
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }


    //配置Swagger信息
    private ApiInfo apiInfo() {
        return new ApiInfo(
                // 标题
                "Swagger项目管理",
                // 描述
                "Swagger项目管理接口测试文档",
                // 版本号
                "1.0",
                // 服务网址
                "https://bareth.blog.csdn.net/",
                // 联系人信息
                new Contact("why", "https://bareth.blog.csdn.net/", "1648996479@qq.com"),//作者信息
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }
}

