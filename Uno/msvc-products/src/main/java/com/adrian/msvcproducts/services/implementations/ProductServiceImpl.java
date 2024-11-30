package com.adrian.msvcproducts.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adrian.msvcproducts.entities.Product;
import com.adrian.msvcproducts.repositories.ProductRepository;
import com.adrian.msvcproducts.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

 /** 
  * @Autowired
   private ProductRepository repository;
   */  

   final private ProductRepository productRepository;


   public ProductServiceImpl(ProductRepository productRepository){
    this.productRepository = productRepository;
   }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
       return (List<Product>) productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

}
