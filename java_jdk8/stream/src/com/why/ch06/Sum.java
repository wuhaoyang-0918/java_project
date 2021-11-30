package com.why.ch06;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author why
 * @date 2021/9/24 17:36
 * @PackageName com.why.ch06
 * @description
 */
public class Sum {
    public static void main(String[] args) {
        //求和
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        //  Optional<Integer> sum = integerStream.reduce((x, y) -> x + y);
        Optional<Integer> sum1 = integerStream.reduce(Integer::sum);
        System.out.println(sum1.get());



        System.out.println("--------------------------------");



        List<Flower> flowerList = Arrays.asList(
                new Flower("red", 10),
                new Flower("yellow", 7),
                new Flower("pink", 8),
                new Flower("yellow", 8),
                new Flower("red", 12));
        //用来计算总数：
        Long c2 = flowerList.stream().count();
        System.out.println(c2);

        //求和
       // Integer sum1 = flowerList.stream().collect(Collectors.summingInt(Flower::getId));
          int sum = flowerList.stream().mapToInt(Flower::getId).sum();
          System.out.println(sum);

         //平均值
          Double avg = flowerList.stream().collect(Collectors.averagingInt(Flower::getId));
          OptionalDouble average = flowerList.stream().mapToInt(Flower::getId).average();
          System.out.println(avg+"----------" + average.getAsDouble());
    }
}
