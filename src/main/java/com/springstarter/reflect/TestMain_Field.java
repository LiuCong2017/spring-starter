package com.springstarter.reflect;

import com.springstarter.reflect.clazz.Person;

import java.lang.reflect.Field;

public class TestMain_Field {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Class clazz = Class.forName("com.springstarter.reflect.clazz.Student");
        /** 只获取当前类所有声明字段(public, private, protected1) */
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:fields){
            System.out.print(field.getName()+" ");
        }
        System.out.println();

        /** 获取包括父类的所有public字段 */
        fields = clazz.getFields();
        for (Field field:fields){
            System.out.print(field);
        }
        System.out.println();

        /** 获取某个类的所有成员变量指定变量名的字段，不包括基类 */
        Field field = clazz.getDeclaredField("StudentId");
        field.setAccessible(true);
        System.out.println(field.getName());

        /** 获取当前类public成员变量中指定字段名的字段，包括基类 */
        field = clazz.getField("StudentId");
        System.out.println(field.getName());


        Class clazzPerson = Class.forName("com.springstarter.reflect.clazz.Person");
        Person person = new Person("Kavin");
        Field fieldPerson = clazzPerson.getDeclaredField("Name");
        fieldPerson.setAccessible(true);
        Object val = fieldPerson.get(person);
        System.out.println(val);
        //改变私有变量的值
        fieldPerson.set(person,"Liu");
        System.out.println(person.getName());

    }
}
