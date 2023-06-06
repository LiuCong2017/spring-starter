package com.springstarter.b02_spring_fundament.ioc_01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
//        ApplicationContext context = new FileSystemXmlApplicationContext("com/springstarter/ioc_01/applicationContext.xml");
        /** BeanFactory 是 ApplicationContext 的父接口, ApplicationContext 为 BeanFactory 的实现类 */
        BeanFactory factory = context;
        Person person = (Person) factory.getBean("person");
        person.Breath();
    }

}
