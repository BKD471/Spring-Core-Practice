package com.example.springcore;

import com.example.springcore.configurations.MyConfigs;
import com.example.springcore.configurations.WebConfig;
import com.example.springcore.custombeans.Dev;
import com.example.springcore.custombeans.Frameworks;
import com.example.springcore.custombeans.Web;
import com.example.springcore.loosecoupler.Car;
import com.example.springcore.loosecoupler.Driver;
import com.example.springcore.loosecoupler.RangeRover;
import com.example.springcore.loosecoupler.Thar;
import com.example.springcore.scopes.Beanbajao;
import com.example.springcore.scopes.Cobra;
import com.example.springcore.tightcoupler.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import test.OutsideOfMain;

@SpringBootApplication
@ComponentScan(basePackages = {"test", "com.example.springcore"})
public class SpringCoreApplication {

    public static void main(String[] args) {

        //without spring-------------------------------------->
        //tight coupling
        Person p = new Person();
        p.play();

        //loose coupling
        Car c = new RangeRover();
        new Driver(c).drive();

        //Notes: we are creating our own object

        //WITH SPRING ------------------------------------------>
        // 1)declare the beans to be managed by ioc,
        // use component annotaion to declare a bean to be manged by ioc

        // 2) declare the dependencies
        // use autowire to describe the dependecies


        // 3) where to scan for beans
        // inside @SpringBootApplication componentScan annotation is lready present
        // which scans the current package in which main file is in and also the sub packages
        //@ComponentScan(basePackages ="test")

        //get the context
        //ApplicationContext context = SpringApplication.run(SpringCoreApplication.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfigs.class);
        //pick out beans from context
//        Driver driverBean = context.getBean(Driver.class);
//        Car rangeRoverBean = context.getBean(RangeRover.class);
//        Car tharBean = context.getBean(Thar.class);
//        OutsideOfMain outsideOfMainBean = context.getBean(OutsideOfMain.class);
//        System.out.println(String.format("  %s %s %s %s", driverBean, rangeRoverBean, tharBean, outsideOfMainBean));
//
//        //lets drive
//        driverBean.drive();
//
//        //Note in second case with spring,we are not creating object pf driver
//        //but ioc creates person bean, inject dependency of range over into it
//        // and gives it back to us
//
//        //there are two beans of type car in ioc context,
//        // so make sure to annotate one with primary
//
//        //there are two ways to resolve conflict
//        // 1) use primary
//        // 2) use qualifier
//
//        //get only bean of specifc name
//        Car thar = context.getBean("Thar", Thar.class);
//        Car rangeRover = context.getBean("RangeRover", RangeRover.class);
//
//        System.out.println(thar);
//
//
//        ///Anoher way to create and manage beans without @Component
//        Dev devBean = context.getBean(Dev.class);
//        devBean.getStack();

        Beanbajao CobraIsSexy1 = context.getBean(Beanbajao.class);
        CobraIsSexy1.naginDance();

        Beanbajao CobraIsSexy2 = context.getBean(Beanbajao.class);
        CobraIsSexy2.naginDance();

        //both ahascodes are same that means its by default singleton
        //for protype hascodes became different

        System.out.println();

        //proxy modee
        Beanbajao SaperChobol = context.getBean(Beanbajao.class);
        SaperChobol.naginDance();
        System.out.println(SaperChobol.getCobra().myHash());

        Beanbajao SaperChobol1 = context.getBean(Beanbajao.class);
        SaperChobol1.naginDance();
        System.out.println(SaperChobol1.getCobra().myHash());

        //notes  Beanbajao is depenedant on Cobra
        //Beanbajao is singleton while Cobra is prototype
        //for every new Beanbajao request :)), we get same beanbajao and same cobra
        // but since cobra is prototype we want to have different cobra

        //so enable proxy mode for cobra to have diffent  cobras for same beanbajao

        ///Testing diffent configs based setup
        Web webBean = context.getBean(Web.class);

        //note webBean is not created from standard MyConfig but from another config WebConfig
        //but since componentScan present in Myconfig scans all the pacjkages and subpacakages
        //of com.example.springcore and webconfig is also prsent in that location, its gets scanned automatically
        //and bean is created so if config is prsent outside of the scanning path
        //just pass it to ioc cotainer like this
        ApplicationContext context2=new AnnotationConfigApplicationContext(MyConfigs.class, WebConfig.class);



    }


}
