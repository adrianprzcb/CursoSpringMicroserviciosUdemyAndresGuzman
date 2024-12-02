package com.adrian.msvcitems.services;


import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import com.adrian.msvcitems.models.Item;

@Service
public class ProductServiceWebClient implements ItemService{


    private final WebClient.Builder client;

    public ProductServiceWebClient(Builder client){
        this.client = client;
    }

    @Override
    public List<Item> findAll() {
        return this.client.build()
        .get().uri("msvc-products")
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToFlux(Item.class).collectList()
        .block();
    }

    @Override
    public Optional<Item> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

}
