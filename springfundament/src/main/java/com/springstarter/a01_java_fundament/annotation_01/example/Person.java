package com.springstarter.a01_java_fundament.annotation_01.example;

import com.springstarter.a01_java_fundament.annotation_01.CustomDescription;
import lombok.Data;

@CustomDescription(description = "基类")
@CustomDescription(description = "人")
@Data
public class Person {
    private String Name;
}
