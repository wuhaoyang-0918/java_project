package com.why.ch06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author why
 * @date 2021/9/24 16:31
 * @PackageName com.why.ch06
 * @description
 */
public class Main {
    public static void main(String[] args) {
       // 获取10块钱以下并且按照价格排序的花的颜色
        List<Flower> flowerList = Arrays.asList(
                new Flower("red", 10),
                new Flower("yellow", 7),
                new Flower("pink", 8),
                new Flower("white", 8),
                new Flower("black", 12));
        List<String> collect = flowerList.stream()
                .filter(t -> t.getId() < 10)
                .sorted((o1, o2) -> o1.getId().compareTo(o2.getId()))
                //流支持 map() 方法，它会接受一个函数作为参数，这个行数会被应用到每个元素上，并将其映射成一个新的元素。
                .map(Flower::getRed)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);




    }
}
