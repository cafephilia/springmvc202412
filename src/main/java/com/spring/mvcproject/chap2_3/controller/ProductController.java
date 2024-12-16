package com.spring.mvcproject.chap2_3.controller;

import com.spring.mvcproject.chap2_3.entity.Product;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductController {

    // 가상의 메모리 상품 저장소
    private Map<Long, Product> productStore = new HashMap<>();

    public ProductController() {
        productStore.put(1L, new Product(1L, "에어컨", 1000000));
        productStore.put(2L, new Product(2L, "세탁기", 1500000));
        productStore.put(3L, new Product(3L, "공기청정기", 200000));
    }


    //특정 상품 조회 : GET
//    @GetMapping("/products")
//    public String getProduct(Long id, int price){
//        System.out.println("/products?id=%s : GET 요청이 들어옴!".formatted(id));
//        System.out.println("id = " + id);
//        System.out.println("price = " + price);
//        return "";
//    }

//    @GetMapping("/products")
//    public String getProduct(
//            Long id,
//            @RequestParam(required = false,defaultValue = "1000") int price){
//        System.out.println("/products?id=%s : GET 요청이 들어옴!".formatted(id));
//        System.out.println("id = " + id);
//        System.out.println("price = " + price);
//        return "";
//    }

    @GetMapping("/products/{id}")
    @ResponseBody  // JSON 응답
    public Product getProduct(
            @PathVariable Long id
    ) {
        System.out.println("/products/%s  : GET 요청이 들어옴!".formatted(id));
        System.out.println("id = " + id);

        Product product = productStore.get(id);
        return product;
    }


}
