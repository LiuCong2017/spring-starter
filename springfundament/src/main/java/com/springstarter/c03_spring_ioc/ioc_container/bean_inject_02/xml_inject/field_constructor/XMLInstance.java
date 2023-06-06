package com.springstarter.c03_spring_ioc.ioc_container.bean_inject_02.xml_inject.field_constructor;

import com.springstarter.b02_spring_fundament.ioc_01.IAir;

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
