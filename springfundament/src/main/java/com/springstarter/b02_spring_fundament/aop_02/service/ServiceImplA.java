package com.springstarter.b02_spring_fundament.aop_02.service;

public class ServiceImplA implements IService{

    @Override
    public void service(String name) throws Exception {
        System.out.println("ServiceImplA name: "+name);
    }

}
