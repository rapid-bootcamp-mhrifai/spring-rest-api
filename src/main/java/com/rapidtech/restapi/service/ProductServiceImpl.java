package com.rapidtech.restapi.service;

import com.rapidtech.restapi.entity.ProductEntity;
import com.rapidtech.restapi.model.Product;
import com.rapidtech.restapi.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAll() {
        List<ProductEntity> result = productRepo.findAll();
        if(result.isEmpty()){
            Collections.emptyList();
        }
        return result.stream().map(Product::new).collect(Collectors.toList());
    }
}
