package com.example.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author why
 * @date 2021/11/8 13:53
 * @PackageName com.example.config
 * @description
 */
@Configuration
@PropertySource("classpath:rabbitmq.properties")
public class RabbitConfig {
    @Value("${com.gupao.directqueue}")
    private String directQueue;
    @Value("${com.gupao.topicqueue}")
    private String topicQueue;
    @Value("${com.gupao.fanoutqueue}")
    private String fanoutQueue;
    @Value("${com.gupao.fanout1queue}")
    private String fanout1Queue;

    @Value("${com.gupao.fanoutexchange}")
    private String fanoutExchange;
    @Value("${com.gupao.directexchange}")
    private String directExchange;
    @Value("${com.gupao.topicexchange}")
    private String topicExchange;

    /**
     * 声明三个队列
     *
     * @return
     */
    @Bean
    public Queue getDirectQueue() {
        return new Queue(directQueue);
    }

    @Bean
    public Queue getTopicQueue() {
        return new Queue(topicQueue);
    }

    @Bean
    public Queue getFanoutQueue() {
        return new Queue(fanoutQueue);
    }

    @Bean
    public Queue getFanout1Queue() {
        return new Queue(fanout1Queue);
    }


    @Bean
    public DirectExchange getDirectExchange() {
        return new DirectExchange(directExchange);
    }

    @Bean
    public TopicExchange getTopicExchange() {
        return new TopicExchange(topicExchange);
    }

    @Bean
    public FanoutExchange getFanoutExchange() {
        return new FanoutExchange(fanoutExchange);
    }

    @Bean
    public Binding bindDirect(@Qualifier("getDirectQueue") Queue queue, @Qualifier("getDirectExchange") DirectExchange exchange){
            return BindingBuilder.bind(queue).to(exchange).with("gupao.best");}
   @Bean
    public Binding bindTopic(@Qualifier("getTopicQueue") Queue queue, @Qualifier("getTopicExchange") TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("*.gupao.*");}
    @Bean
    public Binding bindFanout(@Qualifier("getFanoutQueue") Queue queue, @Qualifier("getFanoutExchange") FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);}
    @Bean
    public Binding bindFanout1(@Qualifier("getFanout1Queue") Queue queue, @Qualifier("getFanoutExchange") FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);}

    /**
     *
     * @return
     */
    @Bean
    DirectExchange lonelyDirectExchange() {
        return new DirectExchange("lonelyDirectExchange");
    }
    /**
     * 在消费端转换json消息
     *
     *
     * @param connectionFactory the connection factory
     * @return the simple rabbit listener container factory
     */
    @Bean
    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);    //或者消费者那里开启(yml)     //开启手动 ack  //没有应答重回队列
        return factory;
    }


   /* @Bean
    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }*/


}




