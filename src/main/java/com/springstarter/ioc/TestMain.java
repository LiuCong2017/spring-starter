package com.springstarter.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
        /** BeanFactory 是 ApplicationContext 的父接口, ApplicationContext 为 BeanFactory 的实现类 */
        BeanFactory factory = context;
        Person person = (Person) factory.getBean("person");
        person.Breath();
    }

}
