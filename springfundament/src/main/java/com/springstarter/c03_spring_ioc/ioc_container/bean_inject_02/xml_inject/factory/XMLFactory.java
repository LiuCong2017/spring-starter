package com.springstarter.c03_spring_ioc.ioc_container.bean_inject_02.xml_inject.factory;

import com.springstarter.b02_spring_fundament.ioc_01.CleanAir;
import com.springstarter.c03_spring_ioc.ioc_container.bean_inject_02.xml_inject.field_constructor.XMLInstance;

public class XMLFactory {

    public XMLInstance CreateInstance(){
        return new XMLInstance("instance",new CleanAir());
    }

    public static XMLInstance CreateStaticInsance(){
        return new XMLInstance("static instance",new CleanAir());
    }

}
