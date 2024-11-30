package com.adrian.msvcproducts.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adrian.msvcproducts.entities.Product;

@Service
public interface ProductService {

    List<Product> findAll();
    Optional<?> findById();


}
