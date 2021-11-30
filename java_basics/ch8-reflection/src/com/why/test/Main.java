package com.why.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author why
 * @date 2021/9/19 17:36
 * @PackageName com.why.test
 * @description
 */
public class Main {
    public static void main(String[] args) throws Exception {

        Class<?> aClass = Class.forName("com.why.test.User");

        //调用无参构造方法进行初始化对象
       /* User user = (User)aClass.newInstance();
        System.out.println(user);*/


        //调用有参构造方法进行初始化对象
       /* Constructor<?> constructor = aClass.getConstructor(Integer.class, String.class);
        User user = (User) constructor.newInstance(12, "aaa");
        System.out.println(user);*/


        //使用反射给属性赋值
      /*  User user = (User)aClass.newInstance();

        Field id = aClass.getDeclaredField("id");
        id.setAccessible(true);//给私有属性赋值
        id.set(user,11);
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user,"11");

        System.out.println(user);*/

        //使用反射调用方法以及方法是否有某个注解
       /* Method enclosingMethod = aClass.getDeclaredMethod("print", Integer.class);
        User user = (User) aClass.newInstance();
        enclosingMethod.invoke(user, 11);

        boolean annotationPresent = enclosingMethod.isAnnotationPresent(Log.class);
        System.out.println(annotationPresent);         //是否有该注解

        Log declaredAnnotation = enclosingMethod.getDeclaredAnnotation(Log.class);
        System.out.println(declaredAnnotation);        //方法没有该注解返回null
        System.out.println(declaredAnnotation.value());//获取注解内容*/



    }
}
