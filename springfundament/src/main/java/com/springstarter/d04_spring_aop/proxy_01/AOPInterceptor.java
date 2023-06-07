package com.springstarter.d04_spring_aop.proxy_01;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class AOPInterceptor implements AfterReturningAdvice, MethodBeforeAdvice, ThrowsAdvice {


    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Method: "+method.getName()+" done, Return: "+returnValue);
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Execute MethodBeforeAdvice, will be execute: "+method.getName());
        if (target instanceof AOPServicesImpl){
            String description = ((AOPServicesImpl) target).getDescription();
            if (description==null){
                throw new NullPointerException("description can't be null");
            }
        }
    }

    public void afterThrowing(Exception e){
        System.out.println("Exception: "+e.getMessage());
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception e){
        System.out.println("Method: "+method.getName()+" exception: "+e.getMessage());
    }

}
