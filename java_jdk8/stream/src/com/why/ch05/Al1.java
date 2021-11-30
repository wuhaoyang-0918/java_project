package com.why.ch05;

import java.util.stream.Stream;

/**
 * @author why
 * @date 2021/9/23 21:40
 * @PackageName com.why.ch05
 * @description
 */
public class Al1 {
    public static void main(String[] args) {
        Stream.of("a1", "a2", "a3")
                .map(s->s.substring(1))//对每个字符串元素从下标1位置开始截取
                .mapToInt(Integer::parseInt)// String类型流转成int基础类型类型流
                .max()//取最大值
                .ifPresent(System.out::println);

    }
}
