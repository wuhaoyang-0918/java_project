package com.why.springcloud.controll;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 昊洋
 * @date:2020-08-24 14:36
 * @PackageName: com.why.springcloud.controll
 * @ClassName: ConfigClientControll
 * @description:
 * @version: 1.0
 */
@RestController
public class ConfigClientControll {
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private  String eurekaServer;

    @Value("${server.port}")
    private String post1;
  @RequestMapping("/config")
    public  String getConfig(){
      return "application:"+applicationName+"-->"
              +"eurekaServer:"+eurekaServer+"-->"
              +"post"+post1
             ;
  }
}
