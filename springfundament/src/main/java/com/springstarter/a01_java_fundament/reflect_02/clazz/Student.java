package com.springstarter.a01_java_fundament.reflect_02.clazz;

import com.springstarter.a01_java_fundament.annotation_01.CustomDescription;
import lombok.Data;

@CustomDescription(description = "学生")
@CustomDescription(description = "人")
@Data
public class Student extends Person{

    public String StudentId;

    public Student(){

    }

    private Student(String name){
        super(name);
        StudentId = "123456";
    }

    public Student(String name,String studentId){
        super(name);
        StudentId = studentId;
    }

    public String StudentPublicMethod(String str){
        return str;
    }

    private String StudentPrivateMethod(String str){
        return str;
    }

}
