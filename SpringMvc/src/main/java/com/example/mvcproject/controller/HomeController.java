package com.example.mvcproject.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller+@ResponseBody ===> @RestController

//@Controller
//@RequestMapping("/api")
//public class HomeController {
//    @GetMapping
//    @ResponseBody
//    public  String home(){
//        return "Home";
//    }
//}


//to resolve either use @ResponseBody+@requestMapping ==>@RestController
//or ResponseEntity<>

//@Controller
//@RequestMapping("/api")
//public class HomeController {
//    @GetMapping
//    @ResponseBody
//    public String home(){
//        return "Home";
//    }
//}

@Controller
@RequestMapping("/api")
public class HomeController {
    @GetMapping
    public ResponseEntity<String> home(){
        return new ResponseEntity<>("Home", HttpStatus.ACCEPTED);
    }
}

//notes: if @ResponseBody is not mentioned then any return from controller method will be treated as view