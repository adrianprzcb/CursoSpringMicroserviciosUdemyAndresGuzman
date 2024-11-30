package com.adrian.msvcproducts.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrian.msvcproducts.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
