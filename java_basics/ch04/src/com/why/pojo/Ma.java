package com.why.pojo;

/**
 * @author why
 * @date 2021/9/7 16:39
 * @PackageName com.why.pojo
 * @description
 */
public class Ma {
    public static void main(String[] args) {
       Long start=System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);

        }
        Long end = System.currentTimeMillis();

        System.out.println("工耗时"+(end-start)+"毫秒");




    }
}
