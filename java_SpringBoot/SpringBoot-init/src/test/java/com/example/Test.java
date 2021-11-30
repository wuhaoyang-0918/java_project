package com.example;

import com.example.pojo.Dog;
import com.example.pojo.Person;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author why
 * @date 2021/9/28 12:12
 * @PackageName com.why.test
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    @Autowired
    private Person person;
    @Autowired
    private Dog dog;

   @org.junit.Test
    public void  sho(){
       //System.out.println(person);
     //  System.out.println(dog);
       //日志的级别；
       //由低到高   trace<debug<info<warn<error
       //可以调整输出的日志级别；日志就只会在这个级别以以后的高级别生效
       logger.trace("这是trace日志...");
       logger.debug("这是debug日志...");
       //SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root(info)级别
       logger.info("这是info日志...");
       logger.warn("这是warn日志...");
       logger.error("这是error日志...");


   }

}
