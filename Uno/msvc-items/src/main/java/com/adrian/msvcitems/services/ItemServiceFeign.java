package com.adrian.msvcitems.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adrian.msvcitems.models.Item;

@Service
public class ItemServiceFeign implements ItemService{

    private ProductOpen

    @Override
    public List<Item> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Item> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    
}
