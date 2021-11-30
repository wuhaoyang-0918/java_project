package com.example.produccer;

import com.example.entrty.Merchant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author why
 * @date 2021/11/8 15:44
 * @PackageName com.example.produccer
 * @description
 */
@Component
public class RabbitSender {
    @Autowired

    RabbitTemplate rabbitTemplate;

    public void send() throws JsonProcessingException {
        Merchant merchant=new Merchant(1,"基础知识");
        ObjectMapper objectMapper=new ObjectMapper();
        String merchant1 = objectMapper.writeValueAsString(merchant);

        //rabbitTemplate.convertAndSend("GP_DIRECT_EXCHANGE","gupao.best",merchant);



      /*  //*.gupao.*
        rabbitTemplate.convertAndSend("GP_TOPIC_EXCHANGE","a.gupao.a","topic Routing Msg: a.gupao.a");
        rabbitTemplate.convertAndSend("GP_TOPIC_EXCHANGE","b.gupao.b","topic Routing Msg: b.gupao.b");

        ObjectMapper objectMapper=new ObjectMapper();
        String merchant1 = objectMapper.writeValueAsString(merchant);
        rabbitTemplate.convertAndSend("GP_FANOUT_EXCHANGE","",merchant1);*/


    }
}
