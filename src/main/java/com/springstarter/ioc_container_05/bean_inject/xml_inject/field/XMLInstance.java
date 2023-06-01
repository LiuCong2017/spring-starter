package com.springstarter.ioc_container_05.bean_inject.xml_inject.field;

import com.springstarter.ioc_03.IAir;

public class XMLInstance {

    private String name;
    private IAir air;

    public void setName(String name) {
        this.name = name;
    }

    public void setAir(IAir air) {
        this.air = air;
    }

    public void Breath(){
        System.out.println("Name: "+this.name + " Air: "+this.air.toString());
    }
}
