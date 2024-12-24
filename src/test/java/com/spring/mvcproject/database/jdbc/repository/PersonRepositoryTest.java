package com.spring.mvcproject.database.jdbc.repository;

import com.spring.mvcproject.database.jdbc.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

//    @Test
//    void saveTest() {
//        Person p = new Person(2L, "뽀로로", 3);
//
//        personRepository.delete(2L);
//    }

    @Test
    void bulkInsertTest(){


    }

    @Test
    void findAllTest(){
        personRepository.findAll();
    }
}