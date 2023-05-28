package com.springstarter.reflect;

import com.springstarter.annotation.CustomDescription;
import com.springstarter.annotation.CustomDescriptions;
import com.springstarter.reflect.clazz.Student;

public class TestMain_Annotation {

    public static void main(String[] args) throws ClassNotFoundException {

        String className = "com.springstarter.reflect.clazz.Student";
        Class<Student> clazz = (Class<Student>) Class.forName(className);
        /** 使用getAnnotation(Class<A> annotationClass)方法，返回该元素指定类型的注解，否则返回null */
        CustomDescriptions customDescriptions = clazz.getAnnotation(CustomDescriptions.class);
        for (CustomDescription cd: customDescriptions.value()){
            System.out.println("description: "+cd.description());
        }

    }

}
