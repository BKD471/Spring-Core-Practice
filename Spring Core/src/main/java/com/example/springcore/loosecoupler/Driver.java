package com.example.springcore.loosecoupler;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Driver {

    private  final Car car;
    @Autowired
    public Driver(@Qualifier("Thar") Car car){
        this.car=car;
    }

    public void drive(){
        car.start();
    }
}
