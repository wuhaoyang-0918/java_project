package com.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * @author why
 * @date 2021/9/29 11:43
 * @PackageName com.example
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Test {


    @org.junit.Test
    public void  sho(){
        log.info("<--------------->1");
        log.error("<--------------->2");
        log.debug("<--------------->3");

    }
}
