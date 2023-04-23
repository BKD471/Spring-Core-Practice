package com.example.springbootdemo.controller;

import com.example.springbootdemo.config.PersonConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/home")
public class HomeController {

    @Value("${best.framework}")
    private String bestFramework;

    private final PersonConfig personConfig;

    public HomeController( PersonConfig personConfig) {
        this.personConfig = personConfig;
    }

    @GetMapping
    public List<String> todos(){
        return Arrays.asList("Learn Spring","Learn SpringBoot","Learn React","Learn Django",bestFramework);
    }

    @GetMapping("/person")
    public PersonConfig getPersonConfig(){
        System.out.println(personConfig);
        return personConfig;
    }
}
