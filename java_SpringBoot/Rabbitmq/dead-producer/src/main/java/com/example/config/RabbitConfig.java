package com.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author why
 * @date 2021/11/10 15:57
 * @PackageName com.example.config
 * @description
 */
@Configuration
@Slf4j
public class RabbitConfig implements  RabbitTemplate.ConfirmCallback{

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(this);
        return rabbitTemplate;
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        log.info(" 消息确认的id： " + correlationData);
        if (b) {
            log.info("消息发送成功");
            //发送成功 删除本地数据库存的消息
        } else {
            log.info("消息发送失败：id " + correlationData + "消息发送失败的原因" + s);
            // 根据本地消息的状态为失败，可以用定时任务去处理数据
        }
    }
}
