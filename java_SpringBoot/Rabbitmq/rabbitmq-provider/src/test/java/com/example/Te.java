package com.example;

import com.alibaba.fastjson.JSONObject;

import com.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * @author why
 * @date 2021/11/11 23:27
 * @PackageName com.example
 * @description
 */

@SpringBootTest
public class Te {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessage() throws Exception
    {
        User merchant=new User(1,"基础知识");
        String jsonString = JSONObject.toJSONString(merchant);

        //设置消息的过期时间5秒或者在队列里设置,还有消息id
        MessageProperties messageProperties = new MessageProperties ();
      //  messageProperties.setExpiration("5000");
        messageProperties.setMessageId(UUID.randomUUID() + "");
        Message message = new Message(jsonString.getBytes (),messageProperties);

        Message message1 = MessageBuilder.withBody(jsonString.getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_JSON).setContentEncoding("utf-8")
                .setExpiration("5000")
                .setMessageId(UUID.randomUUID() + "").build();
        for (int i = 0; i < 9; i++) {
            rabbitTemplate.convertAndSend("exchange_name", "routing_key", message);
        }


        //这里故意将routingKey参数写入错误，让其应发确认消息送到队列失败回调
        // rabbitTemplate.convertAndSend("exchange_name", "no_queue_name", merchant);




    }


}
