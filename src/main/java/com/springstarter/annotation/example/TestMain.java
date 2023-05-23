package com.springstarter.annotation.example;

import com.springstarter.annotation.CustomDescription;
import com.springstarter.annotation.CustomDescriptions;

public class TestMain {

    public static void main(String[] args){
        //通过反射获取注解属性值
        CustomDescriptions customDescriptions = new Student().getClass().getAnnotation(CustomDescriptions.class);
        for (CustomDescription customDescription: customDescriptions.value()){
            System.out.println("description: " + customDescription.description());
        }
    }

}
