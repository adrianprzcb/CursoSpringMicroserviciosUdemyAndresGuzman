package com.adrian.msvcproducts.services.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.core.env.Environment;
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

   final private Environment environment;


   public ProductServiceImpl(ProductRepository productRepository, Environment environment){
    this.productRepository = productRepository;
    this.environment = environment;
   }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
       return ((List<Product>) productRepository.findAll()).stream().map(product ->{
       product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
       return product;
    }).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

}
