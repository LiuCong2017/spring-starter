package com.springstarter.c03_spring_ioc.ioc_container.bean_inject_02.annotation_inject;

import com.springstarter.b02_spring_fundament.ioc_01.IAir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AnnotationInstance {

    @Value("abc")
    private String name;

    public void setName(String name){
        this.name = name;
    }

    //@Resource与@Autowired两者选其一
    @Autowired
    @Qualifier(value = "cleanair")
    private IAir air;

//    @Resource(name = "cleanair")
//    public void setAir(IAir air){
//        this.air = air;
//    }

    public void Breath(){
        System.out.println("Name: "+this.name+" Air: "+this.air.toString());
    }

}
