package com.adrian.msvcitems.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.msvcitems.clients.ProductFeignClient;
import com.adrian.msvcitems.models.Item;

@Service
public class ItemServiceFeign implements ItemService{

    @Autowired
    private ProductFeignClient productFeignClient;

    @Override
    public List<Item> findAll() {
        return productFeignClient.findAll().stream().map(product -> {
            Random random = new Random();
            return new Item(product, random.nextInt(10)+1);
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<Item> findById(Long id) {
        return Optional.ofNullable(new Item(productFeignClient.details(id), new Random().nextInt(10)+1));
    }
    
}
