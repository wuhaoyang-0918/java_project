package cn.why.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 昊洋
 * @date:2020-08-12 20:51
 * @description: 几种负载均衡算法
 * @version: 1.0
 */
@Configuration
public class whyRule {

   //IRule
    //RoundRobinRule 轮询 默认
    //RandomRule 随机
    //RetryRule 会按照轮询获取服务~如果服务获取失败，则会在指定时间内进行,重试
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
