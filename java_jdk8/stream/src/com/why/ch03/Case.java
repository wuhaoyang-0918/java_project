package com.why.ch03;

import com.why.ch01.UserEntity;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author why
 * @date 2021/9/23 13:21
 * @PackageName com.why.ch03
 * @description
 */
public class Case {
    public static void main(String[] args) {
        //要求：对数据流的数据实现降序排列、且名称为mayikt 获取后两位数据
        ArrayList<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity("mayikt", 20));
        userEntities.add(new UserEntity("meite", 28));
        userEntities.add(new UserEntity("zhangsan", 35));
        userEntities.add(new UserEntity("xiaowei", 16));
        userEntities.add(new UserEntity("mayikt_list", 109));
        userEntities.add(new UserEntity("mayikt_zhangsan", 110));
        userEntities.add(new UserEntity("lisi", 109));
        userEntities.add(new UserEntity("mayikt", 66));
        userEntities.add(new UserEntity("mayikt", 78));
        userEntities.add(new UserEntity("mayikt", 32));
        Stream<UserEntity> stream = userEntities.stream();
        stream.sorted(((o1, o2) -> o2.getAge()-o1.getAge()))  //o1.getAge()-o2.getAge()升序
                .filter((UserEntity)-> "mayikt".equals(UserEntity.getUserName()))
                .skip(2).limit(2).forEach(System.out::println);
    }
}
