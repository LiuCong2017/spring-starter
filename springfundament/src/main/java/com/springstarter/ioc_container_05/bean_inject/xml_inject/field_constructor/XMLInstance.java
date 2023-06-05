package com.springstarter.ioc_container_05.bean_inject.xml_inject.field_constructor;

import com.springstarter.ioc_03.IAir;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class XMLInstance {

    private String name;
    private IAir air;

    public XMLInstance(String name, IAir air){
        super();
        this.name = name;
        this.air = air;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAir(IAir air) {
        this.air = air;
    }

    public void Breath(){
        System.out.println("Name: "+this.name + " Air: "+this.air.toString());
    }

    /** 初始化函数，销毁函数 */
//    @PreDestroy
    public void DestroyMethod(){
        System.out.println("DestroyMethod");
    }
//    @PostConstruct
    public void InitMethod(){
        System.out.println("InitMethod");
    }

}
