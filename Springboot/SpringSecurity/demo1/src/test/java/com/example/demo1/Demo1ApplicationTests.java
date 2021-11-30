package com.example.demo1;

import com.example.demo1.service.UseService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class Demo1ApplicationTests {
  @Autowired
  private UseService useService;
    @Test
    void contextLoads() {
        System.out.println(useService.queryUserByName("123"));
    }

}
