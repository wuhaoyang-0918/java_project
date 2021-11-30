package com.example;

import com.example.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author why
 * @date 2021/10/21 21:10
 * @PackageName com.example
 * @description
 */
@SpringBootTest
public class TestController {
    @Autowired
    private HelloController helloController;
    @Test
    public void show(){
        System.out.println(helloController);
    }

}
