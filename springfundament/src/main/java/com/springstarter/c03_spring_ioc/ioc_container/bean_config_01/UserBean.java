package com.springstarter.c03_spring_ioc.ioc_container.bean_config_01;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class UserBean  implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
    @Override
    public void setBeanName(String name) {
        System.out.println(name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean");
    }

}
