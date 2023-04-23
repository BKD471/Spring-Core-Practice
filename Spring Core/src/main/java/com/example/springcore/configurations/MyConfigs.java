package com.example.springcore.configurations;

import com.example.springcore.custombeans.Frameworks;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



// this annotation denotes this class has bean defn methods
//this is used to create beans by IOC
@Configuration
@ComponentScan(basePackages = "com.example.springcore")
public class MyConfigs {

    @Bean(name="BACKEND")
    public Frameworks getFrameworks1(){
        return new Frameworks("Spring");
    }

    @Bean(name="UI")
    public Frameworks getFrameworks2(){
        return  new Frameworks("Angular");
    }
}
