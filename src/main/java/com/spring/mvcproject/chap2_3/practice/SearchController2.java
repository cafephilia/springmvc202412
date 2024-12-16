package com.spring.mvcproject.chap2_3.practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SearchController2 {
    @GetMapping("/search")
    public String search(String query, @RequestParam(required = false,defaultValue = "1") int page){
        return "Query: "+query+" Page: "+page;
    }
}
