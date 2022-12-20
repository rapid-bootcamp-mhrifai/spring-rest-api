package com.rapidtech.restapi.service;

import com.rapidtech.restapi.model.Product;
import com.rapidtech.restapi.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAll() {
        return null;
    }
}
