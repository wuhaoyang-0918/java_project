package com.example;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) {
         ConfigurableApplicationContext run = SpringApplication.run(WebApplication.class, args);
        // String[] beanDefinitionNames = run.getBeanDefinitionNames();
      /*  for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName+"--->||"+run.getBean(beanDefinitionName));
        }*/
        System.out.println(run.getBean(UserService.class).getClass().getName());//反射获取名称
        System.out.println("是否包含:"+run.containsBean("tom"));
         User bean = run.getBean(User.class);
         User bean1 = run.getBean(User.class);
        System.out.println(bean==bean1);
       ;
    }
}
