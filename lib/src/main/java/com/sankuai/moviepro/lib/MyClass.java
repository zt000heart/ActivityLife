package com.sankuai.moviepro.lib;

public class MyClass {
    public static void main(String[] args){
        A a = new A();
        System.out.println(a.getClass().getClassLoader());
        System.out.println(a.getClass().getClassLoader().getParent());
        System.out.println(a.getClass().getClassLoader().getParent().getParent());
    }
}

