package com.example.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author why
 * @date 2021/11/10 15:55
 * @PackageName com.example.config
 * @description
 */
@Configuration
public class RabbitConfig {
    public static final String ORDER_QUEUE = "orderQueue";
    public static final String ORDER_DIRECT_EXCHANGE = "order_direct_exchange";

    public static final String ORDER_TTL_QUEUE = "order_ttl_Queue";
    public static final String ORDER_TTL_DIRECT_EXCHANGE = "order_ttl_direct_exchange";

    private static final String ORDER_ROUTING_KEY ="order.message";
    private static final String ORDER_TTL_ROUTING_KEY="order.ttl.message";
    /**
     * 死信队列  交换机标识符
     */
    public static final String DEAD_LETTER_QUEUE_KEY = "x-dead-letter-exchange";
    /**
     * 死信队列  交换机绑定键标识符
     */
    public static final String DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";

    /**
     * 订单实际消费队列 绑定到死信队列交换机上
     */
    @Bean
    public Queue orderQueue() {
      return  QueueBuilder
                .durable(ORDER_QUEUE)
                .withArgument(DEAD_LETTER_QUEUE_KEY, ORDER_TTL_DIRECT_EXCHANGE)
                .withArgument(DEAD_LETTER_ROUTING_KEY, ORDER_TTL_ROUTING_KEY)
                .withArgument("x-message-ttl", 5000)  //队列消息5秒没有被消费进入死信队列   注意:三者可同时设置共存
                .withArgument("x-max-length", 2)        //队列2条消息没有被消费，第三条开始被消费 消息先进先出id(1,2,3) 第三条开始出1
                 //channel.basicNack(deliveryTag,false,false);     前提开启手动ACk拒绝该消息,放入死信队列
                .build();
    }
    /**
     * 订单消息实际消费队列所绑定的交换机
     */
    @Bean
    DirectExchange orderDirect() {
        return new DirectExchange(ORDER_DIRECT_EXCHANGE);
    }

    /**
     * 将订单队列绑定到交换机
     */
    @Bean
    Binding orderBinding(DirectExchange orderDirect, Queue orderQueue) {
        return BindingBuilder
                .bind(orderQueue)
                .to(orderDirect)
                .with(ORDER_ROUTING_KEY);
    }


    /**
     * 所绑定的死信交换机
     * 订单延迟队列
     */
    @Bean
    DirectExchange orderTtlDirect() {
        return new DirectExchange(ORDER_TTL_DIRECT_EXCHANGE);
    }

    /**
     * 订单延迟队列（死信队列）
     */
    @Bean
    public Queue orderTtlQueue() {
        return new Queue(ORDER_TTL_QUEUE);
    }

    /**
     * 将订单延迟队列绑定到交换机
     */
    @Bean
    Binding orderTtlBinding(DirectExchange orderTtlDirect, Queue orderTtlQueue) {
        return BindingBuilder
                .bind(orderTtlQueue)
                .to(orderTtlDirect)
                .with(ORDER_TTL_ROUTING_KEY);
    }



    @Bean
    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return factory;
    }
}
