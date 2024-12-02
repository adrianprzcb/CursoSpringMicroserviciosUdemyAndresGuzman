package com.adrian.msvcitems.services;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import com.adrian.msvcitems.models.Item;
import com.adrian.msvcitems.models.Product;

//@Primary
@Service
public class ItemServiceWebClient implements ItemService{


    private final WebClient.Builder client;

    public ItemServiceWebClient(Builder client){
        this.client = client;
    }

    @Override
    public List<Item> findAll() {
        return this.client.build()
        .get().uri("http://msvc-products")
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToFlux(Product.class)
        .map(product -> new Item(product, new Random().nextInt(10)+1))
        .collectList()
        .block();
    }

    @Override
    public Optional<Item> findById(Long id) {
        
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        try {
            return Optional.of(this.client.build().get().uri("http://mscv-products/{id}" , params)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Product.class)
            .map(product -> new Item(product, new Random().nextInt(10)+1))
            .block());
        } catch (Exception e) {
           return Optional.empty();
        }
    
    }

}
