package com.example.consumber;

import com.example.pojo.User;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author why  变成死信
 * @date 2021/11/10 16:48
 * @PackageName com.example.consumber
 * @description
 */
@Component
@RabbitListener(queues ="order_ttl_Queue")
public class DeadConsumber {

    /**
     * Process.
     * rabbitTemplate.convertAndSend("order_direct_exchange","order.message",merchant,correlationData);
     * @param merchant the merchant
     * @param channel  the channel
     * @param message  the message
     * @param map      the map
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */

    @RabbitHandler
    public void process(@Payload User merchant, Channel channel,  Message message,@Headers Map<String,Object> map) throws UnsupportedEncodingException   {
        System.out.println("----------死信队列------------");

        System.out.println("死信队列消费者获取生产者消息msg:" + merchant + ",消息回调id:" + message.getMessageProperties().getHeaders().get("spring_returned_message_correlation"));

        long deliveryTag = message.getMessageProperties().getDeliveryTag();

        System.out.println("死信队列消费者获取生产者消息msg:" + new String(message.getBody(),"UTF-8") + ",消息id:" + deliveryTag);
        try {
            channel.basicAck(deliveryTag,false);   //手动确认消息
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Process.
     * rabbitTemplate.convertAndSend("order_direct_exchange","order.message",Message,correlationData);
     * @param channel  the channel
     * @param message  the message
     * @param map      the map
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
   // @RabbitHandler
    public void process(Message message, Channel channel, @Headers Map<String,Object> map) throws UnsupportedEncodingException   {
        System.out.println("----------死信队列------------");
        // 获取消息Id
        String messageId = message.getMessageProperties().getMessageId();
        String msg = new String(message.getBody(), "UTF-8");

        Long deliveryTag = (Long) map.get(AmqpHeaders.DELIVERY_TAG);

        System.out.println("死信队列消费者获取生产者消息msg:" + msg + ",消息messageId:" + messageId+"  消息id:" + deliveryTag);
        System.out.println("消息回调id:" + message.getMessageProperties().getHeaders().get("spring_returned_message_correlation"));


        try {
            channel.basicAck(deliveryTag,false);   //手动确认消息
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
