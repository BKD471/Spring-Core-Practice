package com.example.springcore.loosecoupler;

import org.springframework.stereotype.Component;

@Component("Thar")
public class Thar implements  Car{

    @Override
    public  void start(){
        System.out.println("Thar is starting....");
    }
}
