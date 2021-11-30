package com.example.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author why
 * @date 2021/11/11 23:11
 * @PackageName com.example.config
 * @description
 */
@Configuration
public class RabbitMqConfig {
    public static final String QUEUE_NAME = "queue_name"; //队列名称
    public static final String EXCHANGE_NAME = "exchange_name"; //交换器名称
    public static final String ROUTING_KEY = "routing_key"; //路由键

    /**
     * 队列
     */
    @Bean
    public Queue queue()
    {
        return new Queue(QUEUE_NAME,true);
    }
    /**
     * Direct交换器
     */
    @Bean
    public DirectExchange exchange()
    {
        return new DirectExchange(EXCHANGE_NAME, true, false);
    }


    /**
     * 绑定
     *
     * @param exchange the exchange
     * @param queue    the queue
     * @return the binding
     */
    @Bean
    Binding binding(DirectExchange exchange, Queue queue)
    {
        //将队列和交换机绑定, 并设置用于匹配键：routingKey
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    /**
     * 在消费端转换json消息
     *
     *
     * @param connectionFactory the connection factory
     * @return the simple rabbit listener container factory
     */
    /*@Bean
    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return factory;
    }*/
    }



