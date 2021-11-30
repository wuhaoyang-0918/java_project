package com.example.controller;

import com.example.entrty.Merchant;
import com.example.produccer.RabbitSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author why
 * @date 2021/11/9 22:10
 * @PackageName com.example.controller
 * @description
 */
@RestController
public class Tes {
    @Autowired
    private  RabbitTemplate rabbitTemplate;

    @RequestMapping("/send")
    public String sendTest()  {
        Merchant merchant=new Merchant(1,"基础知识");



        CorrelationData correlationData = new CorrelationData("id_"+System.currentTimeMillis()+"");
       //找不到交换机  调用ConfirmCallback(false)
       // rabbitTemplate.convertAndSend("non-existent-exchange","gupao.best",merchant);

       //找不到队列  调用消息发送成功到交换机ConfirmCallback(true) ReturnsCallbacks
       // rabbitTemplate.convertAndSend("lonelyDirectExchange", "TestDirectRouting", merchant,correlationData);

        //成功发送调用  ConfirmCallback(true)

         rabbitTemplate.convertAndSend("GP_DIRECT_EXCHANGE","gupao.best",merchant,correlationData);
        // rabbitTemplate.convertAndSend("GP_DIRECT_EXCHANGE","gupao.best","aaa",correlationData);
        return "success";
    }
}
