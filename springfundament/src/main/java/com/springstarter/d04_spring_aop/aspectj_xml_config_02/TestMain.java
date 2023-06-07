package com.springstarter.d04_spring_aop.aspectj_xml_config_02;

import com.springstarter.d04_spring_aop.proxy_01.IAOPServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IAOPServices services = (IAOPServices) context.getBean("serviceImplA");
        services.withAopMethod();
        services.withNoAopMethod();
    }
}
