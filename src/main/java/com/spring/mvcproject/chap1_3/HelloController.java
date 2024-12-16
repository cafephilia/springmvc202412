package com.spring.mvcproject.chap1_3;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//Controller: 클라이언트의 요청을 받아 로직을 수행하는 역할
@Controller
@RequestMapping("/chap01")
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println("hello spring mvc world!");
        return "안녕하시렵니까";
    }
    @RequestMapping("/bye")
    @ResponseBody
    public String bye(){
        System.out.println("bye spring mvc world!");
        return "안녕히가십쇼";
    }
}
