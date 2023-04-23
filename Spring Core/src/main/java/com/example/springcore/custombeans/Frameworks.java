package com.example.springcore.custombeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Frameworks {
    private String name;

    public Frameworks(String name){
        this.name=name;
    }
    public void getFramework(){
        System.out.println("I am working on "+this.name);
    }
}
