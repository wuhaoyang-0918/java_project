package com.example.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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
        User merchant=new User(1,"基础知识");
        String jsonString = JSONObject.toJSONString(merchant);


        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        CorrelationData correlationData = new CorrelationData("id_"+System.currentTimeMillis()+"");

       //设置消息的过期时间5秒或者在队列里设置,还有消息id
        MessageProperties messageProperties = new MessageProperties ();
        messageProperties.setExpiration("5000");
        messageProperties.setMessageId(UUID.randomUUID() + "");
        Message message = new Message(jsonString.getBytes (),messageProperties);

        //设置消息的过期时间5秒或者在队列里设置,还有消息id
        Message message1 = MessageBuilder.withBody(jsonString.getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_JSON).setContentEncoding("utf-8")
                .setExpiration("5000")
                .setMessageId(UUID.randomUUID() + "").build();

        //传入实体类对象
         rabbitTemplate.convertAndSend("order_direct_exchange","order.message",merchant,correlationData);

        //传入message对象
        //rabbitTemplate.convertAndSend("order_direct_exchange","order.message",message,correlationId);
        //rabbitTemplate.convertAndSend("order_direct_exchange","order.message",message1,correlationData);
         return "success";


    }
}
