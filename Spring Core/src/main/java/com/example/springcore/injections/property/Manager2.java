package com.example.springcore.injections.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Manager2 {

    @Autowired
    private  Employee3 e1;
    @Autowired
    private   Employee4 e2;



    public  void getWork(){
       e1.doWork();
       e2.doWork();
    }
}
