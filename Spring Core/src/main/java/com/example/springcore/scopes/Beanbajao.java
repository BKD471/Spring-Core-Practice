package com.example.springcore.scopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope("prototype")
public class Beanbajao {

    @Autowired
    Cobra cobra;

    public void naginDance() {
        System.out.println("Nagin nagin......." + this.hashCode());
    }

    public Cobra getCobra() {
        return cobra;
    }
}
