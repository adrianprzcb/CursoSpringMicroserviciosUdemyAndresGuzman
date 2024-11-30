package com.adrian.msvcproducts.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.msvcproducts.entities.Product;
import com.adrian.msvcproducts.services.ProductService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ProductController {

    final private ProductService productService;


    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping
    public List<Product> list() {
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public Product details(@PathVariable Long id) {
        Optional<Product> productOpt = 
    }
    



}
