package com.adrian.msvcproducts.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.msvcproducts.entities.Product;
import com.adrian.msvcproducts.services.ProductService;


@RestController
//@RequestMapping("/api/products")
public class ProductController {

    final private ProductService productService;


    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<List<Product>> list() {
        return ResponseEntity.ok(this.productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id) {
        Optional<Product> productOpt = productService.findById(id);

        if(productOpt.isPresent()){
            return ResponseEntity.ok(productOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();     
    }
    



}
