package com.why.ch01;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author why
 * @date 2021/9/22 17:32
 * @PackageName com.why.ch01
 * @description
 */
public class Main1 {
    public static void main(String[] args) {
        //list转map
        ArrayList<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity("meite", 28));
        userEntities.add(new UserEntity("zhangsan", 35));
        Stream<UserEntity> stream = userEntities.stream();               //key                    value
        Map<String, UserEntity> collect = stream.collect(Collectors.toMap(UserEntity::getUserName,userEntity -> userEntity));
        collect.forEach((key,value)-> System.out.println("key:"+key+"-------"+"value:"+value));
    }
}
