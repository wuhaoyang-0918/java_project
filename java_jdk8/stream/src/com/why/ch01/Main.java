package com.why.ch01;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author why
 * @date 2021/9/22 17:04
 * @PackageName com.why.ch01
 * @description
 */
public class Main {
    public static void main(String[] args) {
        // List转换成set集合
        ArrayList<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity("mayikt", 20));
        userEntities.add(new UserEntity("meite", 28));
        userEntities.add(new UserEntity("zhangsan", 35));
        userEntities.add(new UserEntity("zhangsan", 35));
        /**
         //         * 创建stream方式两种
         //         * 1.串行流stream() 单线程
         //         * 2.并行流parallelStream() 多线程
         //         * 并行流parallelStream 比串行流stream()效率要高的
         //         */
        Stream<UserEntity> stream = userEntities.stream();
        // 转换成set集合
        Set<UserEntity> collect = stream.collect(Collectors.toSet());

        collect.forEach(System.out::println);
        collect.forEach(stu -> System.out.println(stu));


    }

}
