package com.springstarter.d04_spring_aop.aspect_annotation_config_03;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotationAdvice {

    @Before("execution(* com.springstarter.d04_spring_aop.proxy_01.AOPServicesImpl.*(..))")
    public void beforeAdvice(){
        System.out.println("前置通知执行了");
    }

    @After("execution(* com.springstarter.d04_spring_aop.proxy_01.AOPServicesImpl.*(..))")
    public void afterAdvice(){
        System.out.println("后置通知执行了");
    }

    @AfterReturning(value = "execution(* com.springstarter.d04_spring_aop.proxy_01.AOPServicesImpl.*(..))",returning = "result")
    public void afterReturnAdvice(String result){
        System.out.println("返回通知执行了，结果:"+result);
    }

    @Around(value = "execution(* com.springstarter.d04_spring_aop.proxy_01.AOPServicesImpl.*(..))")
    public String aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String result = "";
        try {
            System.out.println("环绕通知开始执行");
            long start = System.currentTimeMillis();
            result = (String) proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("环绕通知执行结束");
            System.out.println("时间花费: "+(end-start)+"ms");
        } catch (Throwable e) {

        }
        return  result;
    }

    @AfterThrowing(value = "execution(* com.springstarter.d04_spring_aop.proxy_01.AOPServicesImpl.*(..))",throwing = "e")
    public void throwingAdvice(JoinPoint joinPoint, Exception e){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("异常通知执行了");
        stringBuffer.append("方法:").append(joinPoint.getSignature().getName()).append(" have exception");
        stringBuffer.append("异常信息: ").append(e.getMessage());
        System.out.println(stringBuffer.toString());

    }

}
