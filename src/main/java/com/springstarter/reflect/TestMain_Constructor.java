package com.springstarter.reflect;

import com.springstarter.reflect.clazz.Person;
import com.springstarter.reflect.clazz.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestMain_Constructor {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String className = "com.springstarter.reflect.clazz.Student";
        Class<Student> clazz = (Class<Student>) Class.forName(className);

        /** 获取对应类中public类型的构造函数，且只获取当前类的构造函数 */
        Constructor<Person>[] constructors = (Constructor<Person>[]) Class.forName(className).getConstructors(); //指定成父类之后实际还是获取子类的构造函数
//        for (Constructor<Person> constructor:constructors){
//            System.out.println("getConstructors: "+constructor);
//        }

        /** 获取指定类所有(包括private)构造函数，且只获取当前类的构造函数 */
        Constructor<Student>[] constructorss = (Constructor<Student>[]) Class.forName(className).getDeclaredConstructors();
//        for (Constructor<Student> constructor:constructorss){
//            System.out.println("getDeclaredConstructors: "+constructor);
//        }

        /** 获取指定类中指定参数类型的public构造函数，且只获取当前类的构造函数 */
        Constructor<Student> constructor = clazz.getConstructor(String.class,String.class);
        System.out.println("getConstructor: "+constructor);
        Student obj = constructor.newInstance("Kavin","123456");
        System.out.println(obj.getName());

        /** 获取指定类中指定参数类型的(包括private)构造函数，且只获取当前类的构造函数 */
        constructor = clazz.getDeclaredConstructor(String.class);
        System.out.println("getDeclaredConstructor: "+constructor);
        constructor.setAccessible(true);
        obj = constructor.newInstance("Liu");
        System.out.println(obj.getName());

    }

}
