package com.springstarter.reflect_02.clazz;

import com.springstarter.annotation_01.CustomDescription;
import lombok.Data;

@CustomDescription(description = "基类")
@CustomDescription(description = "人")
@Data
public class Person {
    private String Name;

    public Person(){
        super();
    }

    public Person(String name){
        Name = name;
    }

    public String PersonPublicMethod(String str){
        return str;
    }

    private String PersonPrivateMethod(String str){
        return str;
    }


}
