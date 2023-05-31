package com.springstarter.ioc_container_05;

import com.springstarter.ioc_03.CleanAir;
import com.springstarter.ioc_03.DirtyAir;
import com.springstarter.ioc_03.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** 基于Java类提供Bean定义 */
@Configuration
public class AppConf {

    @Bean
    public CleanAir cleanAir(){
        return new CleanAir();
    }

    @Bean
    public DirtyAir dirtyAir(){
        return new DirtyAir();
    }

    @Bean
    public Person person(){
        return new Person(dirtyAir());
    }

}
