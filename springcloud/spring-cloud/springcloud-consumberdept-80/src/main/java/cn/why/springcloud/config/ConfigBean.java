package cn.why.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 昊洋
 * @date:2020-08-11 19:47
 * @description: ConfigBean
 * @version: 1.0
 */
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced  //Rabbon
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
