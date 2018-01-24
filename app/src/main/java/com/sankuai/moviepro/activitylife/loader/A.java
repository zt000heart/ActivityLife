package com.sankuai.moviepro.activitylife.loader;

/**
 * Created by zhangtao21 on 2017/12/15.
 */

public class A {
    static {
        System.out.println("Initialize class 1");
        B.doSay();
        Class<B> bClass = B.class;
        System.out.println("B Loader is " + bClass.getClassLoader());
    }
    public static void say() {
    }
}



