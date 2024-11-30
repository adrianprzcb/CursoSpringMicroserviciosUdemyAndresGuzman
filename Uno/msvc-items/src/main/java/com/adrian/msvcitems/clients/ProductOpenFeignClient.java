package com.adrian.msvcitems.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.adrian.msvcitems.models.Product;

@FeignClient(url = "localhost:8080")
public interface ProductOpenFeignClient {

    @GetMapping()
    List<Product> findAll();

}
