package com.example.consumber;


import com.example.entrty.Merchant;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.ImmediateAcknowledgeAmqpException;
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
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * The type Direct consumer.
 *
 * @author why
 * @date 2021 /11/8 14:52
 * @PackageName com.example.consumber
 * @description
 */
@Component
@PropertySource("classpath:rabbitmq.properties")
@RabbitListener(queues ="${com.gupao.directqueue}")
public class DirectConsumer {

    /**
     * Process.传入一个字符串
     * rabbitTemplate.convertAndSend("GP_DIRECT_EXCHANGE","gupao.best","aaaaa",correlationData);
     *
     * @param message1 the message 1
     * @param channel  the channel
     * @param tag      the tag
     * @param message  the message
     * @param map      the map
     */
    //@RabbitHandler
    public void process(String message1, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag, Message message, @Headers Map<String, Object> map) {
        //System.out.println("message:  "+message);
        // System.out.println("map:"+map);
        System.out.println("消息内容:  " + message1);
        System.out.println("消息内容:  " + message1);
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        System.out.println("消息id:  " + deliveryTag);
        Long id = (Long) map.get(AmqpHeaders.DELIVERY_TAG);
        System.out.println("消息id:  " + id);


        // 确认消息
        try {
            channel.basicAck(tag, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Process.传入是一个对象
     * rabbitTemplate.convertAndSend("GP_DIRECT_EXCHANGE","gupao.best",merchant,correlationData);
     * @param merchant the merchant
     * @param channel  the channel
     * @param tag      the tag
     * @param message  the message
     * @param map      the map
     * @throws IOException the io exception
     */
    @RabbitHandler
   public void process(@Payload Merchant merchant, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag, Message message,@Headers Map<String,Object> map) throws IOException {
        System.out.println("message消息内容:  " + message);
       //s(json格式):{"id":1,"name":"基础知识"}
        String s = new String(message.getBody(), "UTF-8");
        System.out.println("获取消息'" + s + "'");
        //对象: Merchant(id=1, name=基础知识)
        System.out.println("传入消息:" + merchant);

        System.out.println("消息回调id:" + message.getMessageProperties().getCorrelationId());//null

        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        System.out.println("自增消息id:  " + deliveryTag);

        Long id = (Long) map.get(AmqpHeaders.DELIVERY_TAG);
        System.out.println("自增消息id:  " + id);

        try {
            channel.basicAck(tag, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //当抛出的异常是AmqpRejectAndDontRequeueException异常的时候，则消息会被拒绝，且requeue=false
        //throw new AmqpRejectAndDontRequeueException("消息消费失败");

        //抛出NullPointerException异常则重新入队列 requeue=true
        //throw new NullPointerException("消息消费失败");

        //当抛出ImmediateAcknowledgeAmqpException异常，则消费者会被确认  requeue=false
        // throw new ImmediateAcknowledgeAmqpException("消息消费失败");

        //throw new NullPointerException("consumer fail");



        /*try {
            int i = 10 / 0;
        } catch (Exception e) {
            System.out.println("程序出现异常");
            //  channel.basicAck(tag, false);  //不会重试
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true); //会一直重试，DeliveryTag会持续+1
            // channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false); //直接丢弃
            e.printStackTrace();
        }*/


        /* if(merchant.getId()==1){
           try {
               channel.basicAck(tag,false);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }else {
           try {
               channel.basicNack(tag,false,false);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }*/


    }
}
