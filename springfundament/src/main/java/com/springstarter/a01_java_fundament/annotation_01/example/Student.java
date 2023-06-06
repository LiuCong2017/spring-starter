package com.springstarter.a01_java_fundament.annotation_01.example;

import com.springstarter.a01_java_fundament.annotation_01.CustomDescription;
import lombok.Data;

@CustomDescription(description = "学生")
@CustomDescription(description = "人")
@Data
public class Student extends Person{
    private String StudentId;
}
