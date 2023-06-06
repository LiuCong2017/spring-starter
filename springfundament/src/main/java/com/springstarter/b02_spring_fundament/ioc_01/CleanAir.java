package com.springstarter.b02_spring_fundament.ioc_01;

import org.springframework.stereotype.Component;

@Component
public class CleanAir implements IAir{

    @Override
    public String toString(){
        return "Clean Air";
    }

}
