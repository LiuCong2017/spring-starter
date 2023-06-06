package com.springstarter.c03_spring_ioc.ioc_container.bean_scope_lifecycle_03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserBean userBean = (UserBean) context.getBean("userBean");
        ((ClassPathXmlApplicationContext) context).close();
    }

}
