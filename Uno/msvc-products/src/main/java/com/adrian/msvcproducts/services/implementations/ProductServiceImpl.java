package com.adrian.msvcproducts.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adrian.msvcproducts.entities.Product;
import com.adrian.msvcproducts.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Override
    @Transactional
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    @Transactional
    public Optional<Product> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

}
