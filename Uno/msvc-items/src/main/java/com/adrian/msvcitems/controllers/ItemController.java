package com.adrian.msvcitems.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.msvcitems.models.Item;
import com.adrian.msvcitems.services.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }


    @GetMapping
    public List<Item> list() {
       return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> details(@PathVariable Long id){
        Optional<Item> itemOptional = itemService.findById(id);
        if(itemOptional.isPresent()){
            return ResponseEntity.ok(itemOptional.get());
        }
    }

    

}
