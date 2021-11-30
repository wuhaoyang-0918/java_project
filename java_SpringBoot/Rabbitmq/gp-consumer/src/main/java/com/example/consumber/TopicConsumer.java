package com.example.consumber;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author why
 * @date 2021/11/8 15:08
 * @PackageName com.example.consumber
 * @description
 */
/*@Component
@PropertySource("classpath:rabbitmq.properties")
@RabbitListener(queues ="${com.gupao.topicqueue}")
public class TopicConsumer {
    @RabbitHandler
    public void process(String msgContent, Channel channel, Message message) throws IOException {
        System.out.println("Topic Queue Msg: "+msgContent);
        //消费者对rabbirmq手工应答
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

}*/
