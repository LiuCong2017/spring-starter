package com.springstarter.a01_java_fundament.annotation_01.example;

import com.springstarter.a01_java_fundament.annotation_01.CustomDescription;
import com.springstarter.a01_java_fundament.annotation_01.CustomDescriptions;

public class TestMain {

    public static void main(String[] args){
        //通过反射获取注解属性值
        CustomDescriptions customDescriptions = new Student().getClass().getAnnotation(CustomDescriptions.class);
        for (CustomDescription customDescription: customDescriptions.value()){
            System.out.println("description: " + customDescription.description());
        }
    }

}
