package com.why.ch02;

import com.why.ch01.UserEntity;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author why
 * @date 2021/9/23 10:08
 * @PackageName com.why.ch02
 * @description
 */
public class ContainsKey {
    public static void main(String[] args) {
        //是否有指定key.
        ArrayList<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity("meite", 28));
        userEntities.add(new UserEntity("zhangsan", 35));
        userEntities.add(new UserEntity("王五", 1));
        Stream<UserEntity> stream = userEntities.stream();
       /*  boolean b1 = stream.anyMatch(new Predicate<UserEntity>() {
            @Override
            public boolean test(UserEntity userEntity) {
                return "王五".equals(userEntity.getUserName());
            }
        });*/

       boolean b = stream.anyMatch((UserEntity) -> "zhangsan".equals(UserEntity.getUserName()));
        System.out.println(b);
    }
}
