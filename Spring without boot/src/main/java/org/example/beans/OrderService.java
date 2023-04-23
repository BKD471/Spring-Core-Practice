package org.example.beans;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

  public  void getOrder(){
      System.out.println("Order is made");
  }
}
