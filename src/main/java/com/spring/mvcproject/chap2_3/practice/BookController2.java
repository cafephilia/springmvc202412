package com.spring.mvcproject.chap2_3.practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BookController2 {
    @GetMapping("/books")
    public String getBooks(
            @RequestParam("author") String author,
            @RequestParam("genre") String genre
    ){
        System.out.println("hoho");
        return "Author :"+author+", Genre :"+genre;
    }
}
