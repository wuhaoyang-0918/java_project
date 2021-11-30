package com.why.demo;

import java.lang.annotation.*;

/**
 * @author why
 * @date 2021/9/19 14:21
 * @PackageName com.why.demo
 * @description
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited   //如果父类使用了HeritedApplication注解，则子类可以继承该注解
@interface HeritedApplication {}