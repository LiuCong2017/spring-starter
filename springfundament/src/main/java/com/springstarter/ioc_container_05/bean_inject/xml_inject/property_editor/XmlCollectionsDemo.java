package com.springstarter.ioc_container_05.bean_inject.xml_inject.property_editor;

import lombok.Data;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.*;

@Data
public class XmlCollectionsDemo {

    private List<Object> lists;
    private Properties props;
    private Set<Object> sets;
    private Map<String,Object> maps;
    private Date date;

    public static void main(String[] args) {

//        ApplicationContext context = new ClassPathXmlApplicationContext("com/springstarter/ioc_container_05/bean_inject/xml_inject/applicationContext.xml");
        ApplicationContext context = new FileSystemXmlApplicationContext("springfundament/src/main/java/com/springstarter/ioc_container_05/bean_inject/xml_inject/applicationContext.xml");
        BeanFactory factory = context;
        XmlCollectionsDemo instance = (XmlCollectionsDemo) factory.getBean("xmlCollectionsDemo");

        System.out.println(instance.lists);
        System.out.println(instance.props);
        System.out.println(instance.sets);
        System.out.println(instance.maps);
        System.out.println(instance.date);
    }


}
