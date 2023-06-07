package com.springstarter.d04_spring_aop.proxy_01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IAOPServices services = (IAOPServices) context.getBean("aopService");
        services.withAopMethod();
        services.withNoAopMethod();
    }

}
