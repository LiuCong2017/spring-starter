package com.springstarter.annotation.example;

import com.springstarter.annotation.CustomDescription;
import com.springstarter.annotation.CustomDescriptions;
import lombok.Data;

@CustomDescription(description = "基类")
@CustomDescription(description = "人")
@Data
public class Person {
    private String Name;
}
