package com.example.springcore.injections.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Manager3 {


    private  Employee8 e1;

    private   Employee9 e2;


    public Employee8 getE1() {
        return e1;
    }

    @Autowired
    public void setE1(Employee8 e1) {
        this.e1 = e1;
    }

    public Employee9 getE2() {
        return e2;
    }

    @Autowired
    public void setE2(Employee9 e2) {
        this.e2 = e2;
    }

    public  void getWork(){
       e1.doWork();
       e2.doWork();
    }
}
