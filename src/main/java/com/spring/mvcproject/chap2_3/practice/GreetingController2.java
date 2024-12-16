package com.spring.mvcproject.chap2_3.practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GreetingController2 {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to spring MVC!";
    }

}
