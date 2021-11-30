package com.why.test2;

import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;

/**
 * @author why
 * @date 2021/9/9 15:09
 * @PackageName com.why.test2
 * @description
 */
public class GenericImpl<T> implements Generic<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
