package com.spring.mvcproject.chap2_3.practice;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book2 {
    private Long id;
    private String title;
    private String author;
    private int price;

}
