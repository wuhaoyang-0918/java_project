package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.MsgEntity;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author why
 * @date 2021/11/17 10:52
 * @PackageName com.example.controller
 * @description
 */
@RestController
public class Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/sendMsg")
    public void sendMsg() {
        /**
         * 参数1 交换机名称
         * 参数2 路由key
         * 参数3 发送内容
         */
        MsgEntity msgEntity = new MsgEntity(UUID.randomUUID().toString(),
                "1234", "181111111", "644064779@qq.com");
        String jsonString = JSONObject.toJSONString(msgEntity);
        Message message = MessageBuilder.withBody(jsonString.getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_JSON).setContentEncoding("utf-8")
                .setExpiration("5000")
                .setMessageId(UUID.randomUUID() + "").build();

       //rabbitTemplate.convertAndSend("/mayikt_ex", "", msgEntity);
        //rabbitTemplate.convertAndSend("/mayikt_ex", "", jsonString);
       // rabbitTemplate.convertAndSend("/mayikt_ex", "", message);

        rabbitTemplate.convertAndSend("/mayikt_ex", "", "我是延迟消息你能发现不50000", message1 -> {
           /* message1.getMessageProperties().setExpiration("5000");
            message1.getMessageProperties().setMessageId("1");*/
            return message1;
        });


    }
}

