package com.springstarter.reflect;

public class TestMain {

    public static void main(String[] args) throws ClassNotFoundException {
        //字符串例子
        Class clazz = null;
        clazz = String.class; //类名.class
        System.out.println(clazz);

        clazz = "ReflectionTest".getClass(); //对象.getClass()
        System.out.println(clazz);

        clazz = Class.forName("java.lang.String"); //Class.forName(全类名)
        System.out.println(clazz);

    }

}
