package com.spring.mvcproject.chap2_3.controller;

import com.spring.mvcproject.chap2_3.entity.Product;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/products")
public class ProductController {

    // 가상의 메모리 상품 저장소
    private Map<Long, Product> productStore = new HashMap<>();

    // 상품의 id를 자동 생성
    private long nextId = 1;

    public ProductController() {
        productStore.put(nextId, new Product(nextId, "에어컨", 1000000));
        nextId++;
        productStore.put(nextId, new Product(nextId, "세탁기", 1500000));
        nextId++;
        productStore.put(nextId, new Product(nextId, "공기청정기", 200000));
        nextId++;
    }


    // 특정 상품 조회 : GET
//    @GetMapping("/products")
//    public String getProduct(HttpServletRequest req) {
//        String id = req.getParameter("id");
//        String price = req.getParameter("price");
//
//        System.out.println("/products?id=%s  : GET 요청이 들어옴!".formatted(id));
//        System.out.println("id = " + id);
//        System.out.println("price = " + price);
//        return "";
//    }

    // /products?id=8&price=12000
//    @GetMapping("/products")
//    public String getProduct(
//            @RequestParam("id") Long id,
//            int price
//    ) {
//
//        System.out.println("/products?id=%s  : GET 요청이 들어옴!".formatted(id));
//        System.out.println("id = " + id);
//        System.out.println("price = " + price);
//        return "";
//    }

    // /products?id=8
//    @GetMapping("/products")
//    public String getProduct(
//            Long id,
//            @RequestParam(required = false, defaultValue = "1000") int price
//    ) {
//
//        System.out.println("/products?id=%s  : GET 요청이 들어옴!".formatted(id));
//        System.out.println("id = " + id);
//        System.out.println("price = " + price);
//        return "";
//    }

    @GetMapping("/{id}")
    @ResponseBody  // JSON 응답
    public Product getProduct(
            @PathVariable Long id
    ) {
        System.out.println("/products/%s  : GET 요청이 들어옴!".formatted(id));
        System.out.println("id = " + id);

        Product product = productStore.get(id);
        return product;
    }

    // 전체 게시물 조회요청 처리
    @GetMapping
//    @ResponseBody   // JSON응답
    public List<Product> list() {
//        List<Product> products = new ArrayList<>();
//        for (Long id : productStore.keySet()) {
//            Product product = productStore.get(id);
//            products.add(product);
//        }
        return productStore.values()
                .stream()
                .collect(Collectors.toList());
    }

    // 상품 정보 생성 요청
//    @RequestMapping(value = "", method = RequestMethod.POST)
    @PostMapping
    public String create(
            @RequestParam String name,
            @RequestParam int price
    ) {

        // 상품객체를 생성해서 맵에 저장
        Product newProduct = new Product(nextId, name, price);
//        newProduct.setId(nextId);
//        newProduct.setName(name);
//        newProduct.setPrice(price);
        productStore.put(nextId++, newProduct);

        return "상품이 생성되었습니다! - " + newProduct;
    }

    //상품 수정 요청
    @PutMapping("/{id}")
    public String updateProduct(
            @PathVariable Long id,
            @RequestParam("name") String newName,
            @RequestParam("price") int newPrice
    ){
        Product foundProduct = productStore.get(id);
        foundProduct.setName(newName);
        foundProduct.setPrice(newPrice);

        return "상품이 수정되었습니다.";
    }

    //상품 삭제 요청
    @DeleteMapping("/{id}")
    public String deleteProduct(
            @PathVariable Long id
    ){
        productStore.remove(id);
        return id+"번 상품이 삭제되었습니다.";
    }

}
