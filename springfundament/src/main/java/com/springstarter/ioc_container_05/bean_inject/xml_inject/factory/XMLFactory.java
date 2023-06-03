package com.springstarter.ioc_container_05.bean_inject.xml_inject.factory;

import com.springstarter.ioc_03.CleanAir;
import com.springstarter.ioc_container_05.bean_inject.xml_inject.field_constructor.XMLInstance;

public class XMLFactory {

    public XMLInstance CreateInstance(){
        return new XMLInstance("instance",new CleanAir());
    }

    public static XMLInstance CreateStaticInsance(){
        return new XMLInstance("static instance",new CleanAir());
    }

}
