package com.springstarter.a01_java_fundament.reflect_02;

import com.springstarter.a01_java_fundament.annotation_01.CustomDescription;
import com.springstarter.a01_java_fundament.annotation_01.CustomDescriptions;
import com.springstarter.a01_java_fundament.reflect_02.clazz.Student;

public class TestMain_Annotation {

    public static void main(String[] args) throws ClassNotFoundException {

        String className = "com.springstarter.a01_java_fundament.clazz.reflect_02.Student";
        Class<Student> clazz = (Class<Student>) Class.forName(className);
        /** 使用getAnnotation(Class<A> annotationClass)方法，返回该元素指定类型的注解，否则返回null */
        CustomDescriptions customDescriptions = clazz.getAnnotation(CustomDescriptions.class);
        for (CustomDescription cd: customDescriptions.value()){
            System.out.println("description: "+cd.description());
        }

    }

}
