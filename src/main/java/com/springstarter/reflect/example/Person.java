package com.springstarter.reflect.example;

import com.springstarter.annotation.CustomDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
