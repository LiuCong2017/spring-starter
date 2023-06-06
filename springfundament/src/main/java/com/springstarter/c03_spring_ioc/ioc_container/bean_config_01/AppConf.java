package com.springstarter.c03_spring_ioc.ioc_container.bean_config_01;

import com.springstarter.b02_spring_fundament.ioc_01.CleanAir;
import com.springstarter.b02_spring_fundament.ioc_01.DirtyAir;
import com.springstarter.b02_spring_fundament.ioc_01.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** 基于Java类提供Bean定义 */
@Configuration
public class AppConf {

    @Bean
    public CleanAir cleanAirConf(){
        return new CleanAir();
    }

    @Bean
    public DirtyAir dirtyAirConf(){
        return new DirtyAir();
    }

    @Bean
    public Person personConf(){
        return new Person(dirtyAirConf());
    }

}
