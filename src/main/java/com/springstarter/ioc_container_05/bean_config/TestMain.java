package com.springstarter.ioc_container_05.bean_config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserBean user = (UserBean) context.getBean("user");
        user.destroy();

        AppConf conf = (AppConf) context.getBean("conf");
        conf.person().Breath();
    }

}
