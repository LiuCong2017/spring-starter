package com.springstarter.c03_spring_ioc.ioc_container.bean_config_01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserBean user = (UserBean) context.getBean("user");
        user.destroy();

        AppConf conf = (AppConf) context.getBean("conf");
        conf.personConf().Breath();
    }

}
