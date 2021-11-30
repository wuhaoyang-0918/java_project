package com.why.ch02;

import com.why.ch01.UserEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author why
 * @date 2021/9/23 10:57
 * @PackageName com.why.ch02
 * @description
 */
public class Sorted {
    public static void main(String[] args) {
        //集合排序小->大
        ArrayList<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity("meiTe", 28));
        userEntities.add(new UserEntity("zhangSan", 35));
        userEntities.add(new UserEntity("zhangSan1", 31));
        userEntities.add(new UserEntity("zhangSan2", 37));
        Stream<UserEntity> stream = userEntities.stream();


        System.out.println("-------------升序------------------");
        // stream.sorted(Comparator.comparing(UserEntity::getAge)).forEach(System.out::println);
        // stream.sorted((o1, o2) ->o1.getAge()-o2.getAge()).forEach(System.out::println);

        System.out.println("-------------降序------------------");
        // stream.sorted((o1, o2) ->o2.getAge()-o1.getAge()).forEach(System.out::println);
       //  stream.sorted(Comparator.comparing(UserEntity::getAge).reversed()).forEach(System.out::println);



        System.out.println("------------------------------------------------------------");
        // 按年龄升序排序（自定义排序）
        List<String> newList = userEntities.stream().sorted(Comparator.comparing(UserEntity::getAge))
                .map(UserEntity::getUserName)
                .collect(Collectors.toList());
        // 按年龄倒序排序
        List<String> newList2 = userEntities.stream().sorted(Comparator.comparing(UserEntity::getAge).reversed())
                .map(UserEntity::getUserName)
                .collect(Collectors.toList());
        System.out.println("按工资升序排序：" + newList);
        System.out.println("按工资降序排序：" + newList2);
    }
}
