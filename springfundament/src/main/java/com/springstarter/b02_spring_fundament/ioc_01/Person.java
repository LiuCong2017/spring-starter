package com.springstarter.b02_spring_fundament.ioc_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//基于注解配置Bean
@Component
public class Person {

    IAir air;
    @Autowired
    public Person(@Qualifier("dirtyair")IAir air){
        this.air = air;
    }

    public void Breath(){
        System.out.println(this.air.toString());
    }

}
