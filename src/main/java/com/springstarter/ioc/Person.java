package com.springstarter.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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
