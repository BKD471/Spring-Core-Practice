package com.example.springcore.custombeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {
    private  final Frameworks frameWorks;


    @Autowired
    public Dev(@Qualifier("BACKEND") Frameworks frameWorks){
        this.frameWorks=frameWorks;
    }

    public  void getStack(){
        frameWorks.getFramework();
    }
}
