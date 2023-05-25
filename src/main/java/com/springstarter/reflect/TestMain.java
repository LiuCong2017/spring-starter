package com.springstarter.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMain {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
//        //字符串例子
//        Class clazz = null;
//        clazz = String.class; //类名.class
//        System.out.println(clazz);
//
//        clazz = "ReflectionTest".getClass(); //对象.getClass()
//        System.out.println(clazz);
//
//        clazz = Class.forName("java.lang.String"); //Class.forName(全类名)
//        System.out.println(clazz);


        Class clazz = Class.forName("com.springstarter.reflect.example.Student");
        Method method = null;
        Method[] methods = null;

        methods = clazz.getMethods(); //getMethods: get all public methods (include extends public methods) from clazz except private methods
        for (Method mth:methods){
            System.out.println(mth.getName()+" ");
        }
        System.out.println();

        method = clazz.getMethod("StudentPublicMethod",String.class); //getMethod(获取指定public方法): 需同时指定方法名和参数类型
        System.out.println(method.getName()+" ");
        System.out.println();

        methods = clazz.getDeclaredMethods(); //getDeclareMethods: 只获取当前类的所有(包括私有)方法
        for (Method mth:methods){
            System.out.println(mth.getName()+" ");
        }

        method = clazz.getDeclaredMethod("StudentPrivateMethod",String.class); //getDeclareMethod: 只获取当前类的指定(包括私有)方法，需同时指定方法名和参数类型
        System.out.println(method.getName()+" ");
        System.out.println();

        Object obj = clazz.newInstance();
        method.setAccessible(true); //invoke私有方法必须为true
        String result = (String) method.invoke(obj,"inputParams"); //invoke第一个参数为执行对象，剩余参数为执行方法所传参数
        System.out.println(result);

    }

}
