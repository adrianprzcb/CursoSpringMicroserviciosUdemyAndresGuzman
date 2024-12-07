package com.adrian.msvcitems.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.jar.Attributes.Name;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.msvcitems.models.Item;
import com.adrian.msvcitems.services.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(@Qualifier("itemServiceWebClient") ItemService itemService){
        this.itemService = itemService;
    }


    @GetMapping
    public List<Item> list(@RequestParam(name="name", required = false) String name, @RequestHeader(name = "token-request", required = false) String token ) {
        System.out.println(name);
        System.out.println(token);
       return itemService.findAll();
  
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        
        Optional<Item> itemOptional = itemService.findById(id);
        if(itemOptional.isPresent()){
            return ResponseEntity.ok(itemOptional.get());
        }
        return ResponseEntity.status(404).body(Collections.singletonMap("message", "No existe el producto en el microservicio Product"));
    }

    

}
