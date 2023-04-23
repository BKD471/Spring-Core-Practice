package org.example.config;

import org.example.beans.CartService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.beans")
public class AppConfig {
    @Bean(name="cartService1")
    public CartService cartService() {
        return new CartService();
    }

}
