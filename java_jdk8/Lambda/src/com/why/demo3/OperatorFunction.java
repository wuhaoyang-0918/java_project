package com.why.demo3;

/**
 * @author why
 * @date 2021/9/25 13:42
 * @PackageName com.why.demo3
 * @description
 */
@FunctionalInterface
public interface OperatorFunction<R,T> {
    R operator(T t1,T t2);

}
