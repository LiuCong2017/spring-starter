package com.springstarter.aop_04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * java动态代理必需: InvocationHandler接口 & Proxy类
 */
public class DynamicProxyServiceA implements InvocationHandler {

    private Object target; //目标对象

    /** 生成目标对象的动态代理对象 */
    public Object bind(Object object){
        this.target = object;
        /** 生成动态代理对象 */
        Object obj = Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(),this);
        return obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("method:"+method);
        System.out.println("args:"+args);
        System.out.println("target:"+this.target);

        System.out.println("log start");
        try {
            result = method.invoke(this.target,args); //回调目标对象的方法
        } catch (Exception e) {
            throw e;
        }
        System.out.println("log end");

        return result;
    }

}
