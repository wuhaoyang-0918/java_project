package com.example.consumer;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author why
 * @date 2021/11/11 23:18
 * @PackageName com.example.consumer
 * @description
 */
@Component
public class DirectConsumer {
    @RabbitListener(queues ="queue_name")
    /*@RabbitHandler*/
    public void process(String mes,Message message,Channel channel,@Headers Map<String,Object> map,@Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("接收消息: " + new String(message.getBody(), "UTF-8")+"  messageId:"+ message.getMessageProperties().getMessageId());

        System.out.println("接收消息: " +mes+"  自增消息id:  " + message.getMessageProperties().getDeliveryTag());

        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        /*try {
            int i=10/0;
        } catch (Exception e) {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            e.printStackTrace();
        }*/
       /* try
        {
            channel.basicAck(tag, false);
        } catch (Exception e) {
            e.printStackTrace();
            channel.basicNack(tag, false, false);
            // channel.basicReject(tag, true);
        }*/


    }
}
