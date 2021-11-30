package com.example.cofig;

import com.example.pojo.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author why
 * @date 2021/9/28 13:19
 * @PackageName com.example.cofig
 * @description
 */
@Configuration   //指明当前类是一个配置类；就是来替代之前的Spring配置文件
public class MyConfig {

    @Bean         //将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
    public Dog dog(){
        return new Dog();
    }
}
