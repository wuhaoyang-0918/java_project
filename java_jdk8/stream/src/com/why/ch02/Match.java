package com.why.ch02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author why
 * @date 2021/9/23 20:39
 * @PackageName com.why.ch02
 * @description
 */
public class Match {
    public static void main(String[] args) {
        // 验证 list 中 string 是否有以 a 开头的, 匹配到第一个，即返回 true
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        boolean a = stringCollection.stream()
               // .anyMatch((s) -> s.startsWith("a"));// 验证 list 中 string 是否有以 a 开头的, 匹配到第一个，即返回 true
                //.allMatch((s) -> s.startsWith("a"));// 验证 list 中 string 是否都是以 a 开头的
                .noneMatch((s) -> s.startsWith("z"));// 验证 list 中 string 是否都不是以 z 开头的,
        System.out.println(a);


    }
}
