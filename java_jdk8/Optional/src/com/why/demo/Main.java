package com.why.demo;

import java.util.Optional;

/**
 * @author why
 * @date 2021/9/23 15:56
 * @PackageName com.why.demo
 * @description
 */
public class Main {
    public static void main(String[] args) {
        String userName=null;
        String userName1="myKt";

          /*存值*/
//        Optional<String> userNam = Optional.ofNullable(userName1);
//        System.out.println(userNam.get());

//        Optional<String> userName2 = Optional.of(userName);
//          System.out.println(userName1.get());

         /*判断是否为空*/
//        Optional<String> userNam = Optional.ofNullable(userName);
//        boolean present = userNam.isPresent();
//        //false为null
//        System.out.println(present);

         /*参数为空可以设定默认值 不空不设置*/
//        String lisi = Optional.ofNullable(userName).orElse("lisi");
//        System.out.println(lisi);

         /*过滤*/
        boolean present = Optional.ofNullable(userName1).filter("myKt"::equals).isPresent();

        /*不为空就打印*/
        Optional.ofNullable(userName).ifPresent(System.out::println);

    }
}
