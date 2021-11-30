package com.why.ch02;

import com.why.ch01.UserEntity;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author why
 * @date 2021/9/23 10:21
 * @PackageName com.why.ch02
 * @description
 */
public class Filter {
    public static void main(String[] args) {
        //过滤(可以再过滤)  where userName='zhangSan' and age>18;
        ArrayList<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity("meiTe", 28));
        userEntities.add(new UserEntity("zhangSan", 35));
        Stream<UserEntity> stream = userEntities.stream();
        Stream<UserEntity> userEntityStream = stream.filter((UserEntity) -> "zhangSan".equals(UserEntity.getUserName()) && UserEntity.getAge() > 34);
        userEntityStream.forEach(System.out::println);


    }
}
