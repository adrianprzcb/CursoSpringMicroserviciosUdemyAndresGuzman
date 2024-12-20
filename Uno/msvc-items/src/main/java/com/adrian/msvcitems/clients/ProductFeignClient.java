package com.adrian.msvcitems.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.adrian.msvcitems.models.Product;
//@FeignClient(url = "localhost:8080", name = "msvc-products")
@FeignClient( name = "msvc-products")
public interface ProductFeignClient {

    @GetMapping()
    List<Product> findAll();

    @GetMapping("/{id}")
    Product details(@PathVariable Long id);

}
