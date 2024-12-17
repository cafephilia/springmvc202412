package com.spring.mvcproject.chap2_3.practice;

import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/books")
public class BookController2 {
    private Map<Long,Book2> bookStore = new HashMap<>();
    private long nextId = 1;
    public BookController2(){
        bookStore.put(nextId,new Book2(nextId++,"해리포터","조앤롤링",50000));
        bookStore.put(nextId,new Book2(nextId++,"반지의 제왕","톨킨",70000));
        bookStore.put(nextId,new Book2(nextId++,"헝거게임","수잔",50000));
        bookStore.put(nextId,new Book2(nextId++,"거래의 기술","트럼프",20000));
        bookStore.put(nextId,new Book2(nextId++,"생명이 있는 것은 다 아름답다","최재천",15000));
    }
    @GetMapping
    public List<Book2> listBooks(){
        return bookStore.values().stream().toList();
    }
    @GetMapping("/{id}")
    public String getBook(
            @PathVariable Long id){
        Book2 book = bookStore.get(id);
        return "책 제목 : "+book.getTitle()+" 저자 : "+book.getAuthor()+" 가격 : "+book.getPrice();
    }
    @PostMapping
    public String addBook(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam int price
    ){
        Book2 newBook = new Book2(nextId,title,author,price);
        bookStore.put(nextId++,newBook);
        return "새 책이 등록되었습니다.";
    }
    @PutMapping("/{id}")
    public String editBook(
            @PathVariable Long id,
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam int price
    ){
        Book2 foundBook = bookStore.get(id);
        foundBook.setTitle(title);
        foundBook.setAuthor(author);
        foundBook.setPrice(price);
        return "책 정보가 수정되었습니다.";
    }
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id){
        bookStore.remove(id);
        return id+"번째 책이 삭제되었습니다.";
    }
}
