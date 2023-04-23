package com.example.springcore.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Student {

   Student(){
       System.out.println("Student being created.....");
   }

  //lifecycle aanotation--->this will be called after Student bean is created
  // and any dependency that is specified is injected
    //this can be used for any type of initialization
   @PostConstruct
    public  void beanCreatedAndDepenecyInserted(){
       System.out.println("Init called...............");
   }

   //this will be called before destroying the bean
    //this can be used for cleaning up things
   @PreDestroy
   public  void beforeDestroy(){
       System.out.println("Adios........");
   }
}
