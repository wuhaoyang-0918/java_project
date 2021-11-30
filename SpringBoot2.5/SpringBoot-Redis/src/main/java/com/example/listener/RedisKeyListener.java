package com.example.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * The type Redis key listener.
 *
 * @author why
 * @date 2021 /10/28 16:23
 * @PackageName com.example.listener
 * @description
 */
@Component
public class RedisKeyListener extends KeyExpirationEventMessageListener {
    public RedisKeyListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
         String s = message.toString();
        System.out.println("该key:"+s+"失效了");
    }
}
