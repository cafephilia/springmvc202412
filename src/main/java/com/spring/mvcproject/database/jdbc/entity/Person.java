package com.spring.mvcproject.database.jdbc.entity;

import lombok.*;

@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Long id;
    private String personName;
    private int age;
}
