package com.why.ch06;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author why
 * @date 2021/9/24 16:51
 * @PackageName com.why.ch06
 * @description
 */
public class Group {
    public static void main(String[] args) {

        List<Flower> flowerList = Arrays.asList(
                new Flower("red", 10),
                new Flower("yellow", 7),
                new Flower("pink", 8),
                new Flower("yellow", 8),
                new Flower("red", 12));
        //按照花的颜色进行分类，获取一个Map<String, List<Flower>>
        Map<String, List<Flower>> collect = flowerList.stream().collect(Collectors.groupingBy(Flower::getRed));
        collect.forEach((kry,value)-> System.out.println(kry+"---"+value));

        // 统计每种颜色的数量：Map<String, Long>
        Map<String, Long> collect1 = flowerList.stream().collect(Collectors.groupingBy(Flower::getRed, Collectors.counting()));
        collect1.forEach((key,value)-> System.out.println(key+"---"+value));

       // 按id是否高于7分组
        Map<Boolean, List<Flower>> part = flowerList.stream().collect(Collectors.partitioningBy(x -> x.getId()>7));
        System.out.println(part);

    }
}
