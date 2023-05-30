package com.springstarter.ioc;

import org.springframework.stereotype.Component;

@Component
public class CleanAir implements IAir{

    @Override
    public String toString(){
        return "Clean Air";
    }

}
