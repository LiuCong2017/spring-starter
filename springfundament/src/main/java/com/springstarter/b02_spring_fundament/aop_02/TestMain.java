package com.springstarter.b02_spring_fundament.aop_02;

import com.springstarter.b02_spring_fundament.aop_02.service.IService;
import com.springstarter.b02_spring_fundament.aop_02.service.ServiceImplA;

public class TestMain {

    public static void main(String[] args) throws Exception {
        /** 静态代理 */
        IService serviceA = new ServiceImplA(); //ServiceImplA为目标对象
        IService staticService = new StaticProxyServiceA(serviceA); //StaticProxyServiceA为代理对象，持有目标对象的引用
        staticService.service("Kavin");

        /**
         * 动态代理
         * 将ServiceImplA关联实现了InvocationHandler接口的动态代理对象DynamicProxyServiceA
         * 当动态代理对象调用目标对象方法时，会执行动态代理对象的invoke方法
         */
        IService dynamicService = (IService) new DynamicProxyServiceA().bind(new ServiceImplA());
        dynamicService.service("Liu");

    }

}
