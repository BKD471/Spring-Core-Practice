package com.example.springcore.injections.contructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Manager1 {
    private final  Employee1 e1;
    private  final  Employee2 e2;

    @Autowired
    public Manager1(Employee1 e1,Employee2 e2){
        this.e1=e1;
        this.e2=e2;
    }

    public  void getWork(){
       e1.doWork();
       e2.doWork();
    }
}
