package com.rapidtech.restapi.controller;

import com.rapidtech.restapi.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<Product> get(){
        return Arrays.asList(
                new Product(1,"Kopi Latte",5000.0),
                new Product(2,"Kopi Susu XYZ",2000.0),
                new Product(3,"Kopi White",2500.0)
        );
    }
}
