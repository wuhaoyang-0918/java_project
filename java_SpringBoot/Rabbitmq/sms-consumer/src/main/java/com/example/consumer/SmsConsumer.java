package com.example.consumer;

import com.example.entity.MsgEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @author why
 * @date 2021/11/17 10:59
 * @PackageName com.example.consumer
 * @description
 */
@Slf4j
@Component
//@RabbitListener(queues = "fanout_sms_queue")
public class SmsConsumer {
    /**
     * rabbitTemplate.convertAndSend("/mayikt_ex", "", msgEntity);
     * @param message
     * @throws UnsupportedEncodingException
     */
   /* @RabbitHandler
    public void process(MsgEntity msgEntity) {
        log.info("sms：msgEntity:" + msgEntity);
    }*/

    /**
     *  rabbitTemplate.convertAndSend("/mayikt_ex", "", jsonString);
     * @param message
     * @throws UnsupportedEncodingException
     */
 /*  @RabbitHandler
   public void process(String msgEntity, Message message) throws UnsupportedEncodingException {
       log.info("email：msgEntity:" + msgEntity);
       log.info("email：message:" + new String(message.getBody(),"UTF-8"));

   }*/

    /**
     * rabbitTemplate.convertAndSend("/mayikt_ex", "", message);
     * @param message
     * @throws UnsupportedEncodingException
     */
    @RabbitListener(queues = "fanout_sms_queue")
    public void process(Message message) throws UnsupportedEncodingException {
        log.info("email：message:" + new String(message.getBody(),"UTF-8"));

    }
}
