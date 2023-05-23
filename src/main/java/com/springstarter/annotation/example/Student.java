package com.springstarter.annotation.example;

import com.springstarter.annotation.CustomDescription;
import lombok.Data;

@CustomDescription(description = "学生")
@CustomDescription(description = "人")
@Data
public class Student extends Person{
    private String StudentId;
}
