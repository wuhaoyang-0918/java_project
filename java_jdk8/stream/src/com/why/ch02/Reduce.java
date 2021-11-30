package com.why.ch02;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author why
 * @date 2021/9/23 21:04
 * @PackageName com.why.ch02
 * @description
 */
public class Reduce {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        Optional<String> reduce = stringCollection.stream()
                .sorted()
                .reduce((s1, s2) -> s1 + "#" + s2);
        //System.out.println(reduce.get());
        reduce.ifPresent(System.out::println);
    }
}
