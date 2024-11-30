package com.adrian.msvcproducts.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.adrian.msvcproducts.services.ProductService;

@RestController
public class ProductController {

    final private ProductService productService;


    public ProductController(ProductService productService){
        this.productService = productService;
    }




}
