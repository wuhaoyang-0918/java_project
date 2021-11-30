package com.example;

import com.example.produccer.RabbitSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author why
 * @date 2021/11/8 15:58
 * @PackageName com.example
 * @description
 */
@SpringBootTest
public class SendTest {
    @Autowired
   private RabbitSender rabbitSender;
    @Test
    public void sendTest() throws JsonProcessingException {
        rabbitSender.send();
    }
}
