package com.why.test1;

import sun.security.util.AuthResources_it;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author why
 * @date 2021/9/8 10:05
 * @PackageName com.why.test1
 * @description
 */
public class Ma {
    public static void main(String[] args) throws ParseException {
     List<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(50);
        list.add(20);
        list.add(30);
        Collections.sort(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }
}

