package com.why.ch02;

import com.why.ch01.UserEntity;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author why
 * @date 2021/9/23 9:31
 * @PackageName com.why.ch02
 * @description
 */
public class CollectionSum {
    public static void main(String[] args) {
        //集合求和
        ArrayList<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity("meite", 28));
        userEntities.add(new UserEntity("zhangsan", 35));
        userEntities.add(new UserEntity("王五", 1));
        Stream<UserEntity> stream = userEntities.stream();
        Optional<UserEntity> zs = stream.reduce((userEntity, userEntity2) -> new UserEntity("zs", userEntity.getAge() + userEntity2.getAge()));
       /* Optional<UserEntity> zs1 = stream.reduce(new BinaryOperator<UserEntity>() {
            @Override
            public UserEntity apply(UserEntity userEntity, UserEntity userEntity2) {
                return new UserEntity("zs", userEntity.getAge() + userEntity2.getAge());
            }
        });*/
        System.out.println(zs.get());
        System.out.println(zs.get().getAge());


    }
}
