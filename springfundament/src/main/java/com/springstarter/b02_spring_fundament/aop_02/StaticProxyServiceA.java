package com.springstarter.b02_spring_fundament.aop_02;

import com.springstarter.b02_spring_fundament.aop_02.service.IService;

public class StaticProxyServiceA implements IService {
    private IService service;
    public StaticProxyServiceA(IService service){
        super();
        this.service = service;
    }

    @Override
    public void service(String name) throws Exception {
        System.out.println("log start");
        try {
            service.service(name);
        } catch (Exception e) {
            throw e;
        }
        System.out.println("log end");
    }

}
