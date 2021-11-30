package com.why.ch02;

import com.why.ch01.UserEntity;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author why
 * @date 2021/9/23 10:30
 * @PackageName com.why.ch02
 * @description
 */
public class Limit {
    public static void main(String[] args) {
        //分页操作
        ArrayList<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity("meiTe", 28));
        userEntities.add(new UserEntity("zhangSan", 35));
        userEntities.add(new UserEntity("zhangSan1", 36));
        userEntities.add(new UserEntity("zhangSan2", 37));
        Stream<UserEntity> stream = userEntities.stream();
        //limit(0,2)
        //stream.limit(2).forEach(System.out::println);
        //limit(2,2)
           stream.skip(2).limit(2).forEach(System.out::println);
    }
}
