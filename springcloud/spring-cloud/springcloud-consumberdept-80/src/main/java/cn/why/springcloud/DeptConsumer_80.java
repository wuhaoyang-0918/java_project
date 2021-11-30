package cn.why.springcloud;

import cn.why.myRule.whyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import java.util.Map;

/**
 * @author 昊洋
 * @date:2020-08-11 20:19
 * @description: DeptConsumer_80
 * @version: 1.0
 */
//Ribbon 和 Eureka整合以后,客户端可以直接调用，不用关心ip地址和端口号
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = whyRule.class)
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }
}
