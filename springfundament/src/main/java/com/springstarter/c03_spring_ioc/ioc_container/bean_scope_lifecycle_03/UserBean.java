package com.springstarter.c03_spring_ioc.ioc_container.bean_scope_lifecycle_03;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class UserBean implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean, ApplicationContextAware {

    private String name;

    public UserBean(){
        System.out.println("UserBean's Constructor");
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
        System.out.println("invoke: Set");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("invoke: BeanNameAware");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("invoke: BeanFactoryAware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("invoke: setApplicationContext");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("invoke: InitializingBean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("invoke: DisposableBean");
    }

    //customised init
    public void myInit(){
        System.out.println("invoke: myInit");
    }

    //customised destroy
    public void myDestroy(){
        System.out.println("invoke: myDestroy");
    }

}
