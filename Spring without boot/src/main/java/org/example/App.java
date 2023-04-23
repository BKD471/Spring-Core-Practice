package org.example;

import org.example.beans.CartService;
import org.example.beans.OrderService;
import org.example.beans.UserService;
import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import outsideofyrleague.Repo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
       //create obj of ApplicationContext,
        // but its an interface so find its one of its implementation
        // and crate object for it

        ApplicationContext context=new
                AnnotationConfigApplicationContext(AppConfig.class);

        CartService cartBean=context.getBean("cartService1", CartService.class);
        System.out.println(cartBean);

        OrderService orderBean=context.getBean(OrderService.class);
        orderBean.getOrder();

        UserService userBean=context.getBean(UserService.class);
        userBean.saveUser();

    }
}
