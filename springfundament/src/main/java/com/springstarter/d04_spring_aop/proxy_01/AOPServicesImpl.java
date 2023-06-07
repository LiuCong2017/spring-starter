package com.springstarter.d04_spring_aop.proxy_01;

import lombok.Data;

@Data
public class AOPServicesImpl implements IAOPServices{

    private String description;

    @Override
    public String withAopMethod() throws Exception {
        System.out.println("AOP");
        if (description.trim().length()==0){
            throw new Exception("description can't be null");
        }
        return description;
    }

    @Override
    public String withNoAopMethod() {
        System.out.println("No AOP");
        return description;
    }
}
