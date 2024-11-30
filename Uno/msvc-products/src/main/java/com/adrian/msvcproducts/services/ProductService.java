package com.adrian.msvcproducts.services;

import java.util.List;
import java.util.Optional;


import com.adrian.msvcproducts.entities.Product;

public interface ProductService {

    List<Product> findAll();
    Optional<Product> findById(Long id);


}
