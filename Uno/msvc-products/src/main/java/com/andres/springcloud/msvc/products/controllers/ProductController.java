package com.andres.springcloud.msvc.products.controllers;

import java.lang.annotation.Repeatable;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.andres.libs.msvc.commons.libs_mcvc_commons.entities.Product;
import com.andres.springcloud.msvc.products.services.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProductController {

    final private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id) throws InterruptedException {

        if (id.equals(10L)) {
            throw new IllegalStateException("Producto no encontrado!");
        }
        
        if (id.equals(7L)) {
            TimeUnit.SECONDS.sleep(3L);
        }

        Optional<Product> productOptional = service.findById(id);
        if(productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Product product){
        Optional<Product> productOptional = service.findById(id);
        if(productOptional.isPresent()){
            Product productDb = productOptional.orElseThrow();
            productDb.setName(product.getName());
            productDb.setPrice(product.getPrice());
            productDb.setCreateAt(product.getCreateAt());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productDb));
        }

        return ResponseEntity.notFound().build();

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Product> productOptional = service.findById(id);
        if(productOptional.isPresent()){
            this.service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.noContent().build();
    }
    
    
}
