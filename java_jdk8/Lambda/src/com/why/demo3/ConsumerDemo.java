package com.why.demo3;

import java.util.function.Consumer;

/**
 * @author why
 * @date 2021/9/25 14:21
 * @PackageName com.why.demo3
 * @description
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        sendMsg("15914965512", System.out::println);
    }
    private static void   sendMsg(String phone, Consumer<String> consumer){
        consumer.accept(phone);
    }
}
