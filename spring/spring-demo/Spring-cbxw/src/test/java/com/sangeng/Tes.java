package com.sangeng;

import com.demo.service.AccountService;
import com.demo.service.impl.TestServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author why
 * @date 2021/10/19 13:55
 * @PackageName com.sangeng
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class Tes {
    @Autowired
    private AccountService accountService;

    @Autowired
    private TestServiceImpl testService;


    @Test
    public  void testPropagation(){
        testService.test();
    }
}
