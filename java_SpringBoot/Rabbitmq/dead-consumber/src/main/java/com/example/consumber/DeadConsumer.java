package com.example.consumber;

import com.alibaba.fastjson.JSONObject;

import com.example.pojo.User;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author why  正常消费
 * @date 2021/11/10 23:33
 * @PackageName com.example.consumber
 * @description
 */
@Component
@RabbitListener(queues ="orderQueue")
public class DeadConsumer {

    /**
     * Process.
     *  rabbitTemplate.convertAndSend("order_direct_exchange","order.message",merchant,correlationData);
     * @param merchant the merchant
     * @param channel  the channel
     * @param message  the message
     * @throws IOException the io exception
     */
    //@RabbitHandler
    public void process(@Payload User merchant, Channel channel, Message message) throws IOException {

        System.out.println("消费者获取生产者消息msg:" + merchant + ",消息回调id:" + message.getMessageProperties().getHeaders().get("spring_returned_message_correlation"));

        long deliveryTag = message.getMessageProperties().getDeliveryTag();

        System.out.println("消费者获取生产者消息msg:" + new String(message.getBody(),"UTF-8") + ",消息id:" + deliveryTag);
        try {
            channel.basicNack(deliveryTag,false,false);   //丢弃消息放入死信队列,true一直重复消费,消息不会到死信队列里
            // channel.basicAck(deliveryTag,false);   //手动确认,死信消费者接受不到消息
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        try {
            int result  = 1/0;
            // 手动签收
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            //拒绝消费消息（丢失消息） 给死信队列
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }*/
    }
    /**
     * Process.
     * rabbitTemplate.convertAndSend("order_direct_exchange","order.message",Message,correlationData);
     * @param channel  the channel
     * @param message  the message
     * @param map      the map
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    //@RabbitHandler
    public void process(Message message, Channel channel, @Headers Map<String,Object> map) throws IOException {
        System.out.println("---------------正常消费------------------");
        String messageId = message.getMessageProperties().getMessageId();
        String msg = new String(message.getBody(), "UTF-8");
        System.out.println("消息回调id:" + message.getMessageProperties().getHeaders().get("spring_returned_message_correlation")+"   MessageId:"+messageId);

        long deliveryTag = message.getMessageProperties().getDeliveryTag();

        System.out.println("消费者获取消息msg:" + msg + "消息id:" + deliveryTag);
        try {
            channel.basicNack(deliveryTag,false,false);   //丢弃消息放入死信队列,true一直重复消费,消息不会到死信队列里
            // channel.basicAck(deliveryTag,false);
        } catch (IOException e) {
            e.printStackTrace();
        }
       /*
        JSONObject jsonObject = JSONObject.parseObject(msg);
        Integer timestamp = jsonObject.getInteger("timestamp");
        try {
            int result  = 1/timestamp;
            Long deliveryTag1 = (Long) map.get(AmqpHeaders.DELIVERY_TAG);
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            //拒绝消费消息（丢失消息） 给死信队列
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }*/
    }
}
