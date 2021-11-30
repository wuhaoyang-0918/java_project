package com.example.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author why
 * @date 2021/11/8 15:35
 * @PackageName com.example.config
 * @description
 */
@Configuration
@Slf4j
public class RabbitConfig implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnsCallback{

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        //消息发送失败返回到队列中, yml需要配置 publisher-returns: true
        //默认中交换机处理失败了是不处理的，也不会执行回调函数。设置为true后交换机处理失败了则会将消息回退到生产者
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
        return rabbitTemplate;
    }
   /* @PostConstruct
    public void init() {
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(this);
        rabbitTemplate.setConfirmCallback(this);
    }*/

    /**
     * 不管成功于否，都会调用。
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        log.info(" 消息确认的id： " + correlationData.getId());
        if (b) {
            log.info("消息发送成功");
            //发送成功 删除本地数据库存的消息
        } else {
            log.info("消息发送失败：id " + correlationData.getId() + "消息发送失败的原因" + s);
            // 根据本地消息的状态为失败，可以用定时任务去处理数据

        }
    }
    /**
     * 如果消息未从路由成功发送到队列那么会走这个回调，这里会把消息的整个明细返回
     * 也就是说出错了，才会调用哦。只要将queue改为不存在，就可以成功调用 returnedMessage
     *声明交换机(lonelyDirectExchange) 不绑定队列
     *rabbitTemplate.convertAndSend("lonelyDirectExchange", "TestDirectRouting", merchant,correlationData);
     */

    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {

        System.err.println("ReturnedMessage: " + returnedMessage);
        System.out.println("ReturnCallback:     "+"消息："+returnedMessage.getMessage());
        System.out.println("ReturnCallback:     "+"回应码："+returnedMessage.getReplyCode());
        System.out.println("ReturnCallback:     "+"回应信息："+returnedMessage.getReplyText());
        System.out.println("ReturnCallback:     "+"交换机："+returnedMessage.getExchange());
        System.out.println("ReturnCallback:     "+"路由键："+returnedMessage.getRoutingKey());


    }
   /* @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }*/
}
