package com.rapidtech.restapi.service;

import com.rapidtech.restapi.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
    public Product create(Product product);
}
