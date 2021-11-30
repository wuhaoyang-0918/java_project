package com.example.config;

import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author why
 * @date 2021/11/11 23:18
 * @PackageName com.example.config
 * @description
 */
@Configuration
public class RabbitConfig {
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter()); //可以发送对象其实就是json字符串(可以不用)
        rabbitTemplate.setMandatory(true);
        //确认消息送到交换机(Exchange)回调
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback()
        {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause)
            {
                System.out.println("\n确认消息送到交换机(Exchange)结果：");
                System.out.println("相关数据：" + correlationData);
                System.out.println("是否成功：" + ack);
                System.out.println("错误原因：" + cause);
            }
        });
        //确认消息送到队列(Queue)回调
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                System.out.println("\n确认消息送到队列(Queue)结果：");
                System.out.println("发生消息：" + returnedMessage.getMessage());
                System.out.println("回应码：" + returnedMessage.getReplyCode());
                System.out.println("回应信息：" + returnedMessage.getReplyText());
                System.out.println("交换机：" + returnedMessage.getExchange());
                System.out.println("路由键：" + returnedMessage.getRoutingKey());
            }
        });
        return rabbitTemplate;
    }
}
