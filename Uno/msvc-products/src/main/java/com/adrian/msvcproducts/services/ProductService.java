package com.adrian.msvcproducts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adrian.msvcproducts.entities.Product;

@Service
public interface ProductService {

    List<Product> findAll();
    Optional<Product> findById();


}
