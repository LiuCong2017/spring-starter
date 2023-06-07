package com.springstarter.d04_spring_aop.aspectj_xml_config_02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/** 拦截器方法 */
public class XMLAdvice {

    public void beforeAdvice(){
        System.out.println("before notice");
    }

    public void afterAdvice(){
        System.out.println("after notice");
    }

    public void afterReturnAdvice(String result){
        System.out.println("return notice, result:"+ result);
    }

    public String aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String result = "";
        try {
            System.out.println("around notice start");
            long start = System.currentTimeMillis();
            result = (String) proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("around notice end");
            System.out.println("Time cost: "+(end-start)+"ms");
        } catch (Throwable e) {

        }
        return  result;
    }

    public void throwingAdvice(JoinPoint joinPoint, Exception e){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("exception notice");
        stringBuffer.append("method:").append(joinPoint.getSignature().getName()).append(" have exception");
        stringBuffer.append("exception message: ").append(e.getMessage());
        System.out.println(stringBuffer.toString());

    }

}
