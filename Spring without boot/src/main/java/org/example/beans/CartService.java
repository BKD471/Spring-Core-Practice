package org.example.beans;

import org.springframework.stereotype.Component;

@Component
public class CartService {
    public void createCart(){
        System.out.println("Cart is created");
    }
}
