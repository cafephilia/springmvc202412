package com.spring.mvcproject.chap2_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {

//    @RequestMapping(value="/chap2-2/hello", method= RequestMethod.GET)
    @GetMapping("/chap2-2/hello")
    @ResponseBody
    public String hello(){
        System.out.println("GET요청이 들어옴");
        return "hello spring~";
    }

    // JSP 응답
    @GetMapping("/chap2-2/getjsp")
//    @ResponseBody  // JSP응답이 아닌 JSON응답으로 바뀜
    public String getjsp(){
        return "hello";
    }
}
