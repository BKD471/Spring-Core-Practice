package com.example.springcore.loosecoupler;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component("RangeRover")
//@Primary
public class RangeRover implements Car{
    @Override
    public void start(){
        System.out.println("RangeRover has started..........");
    }
}
