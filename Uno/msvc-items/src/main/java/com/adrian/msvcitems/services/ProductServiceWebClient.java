package com.adrian.msvcitems.services;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import com.adrian.msvcitems.models.Item;

@Service
@Primary
public class ProductServiceWebClient implements ItemService{


    private final WebClient.Builder client;

    public ProductServiceWebClient(Builder client){
        this.client = client;
    }

    @Override
    public List<Item> findAll() {
        return this.client.build()
        .get().uri("http://msvc-products")
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToFlux(Item.class).collectList()
        .block();
    }

    @Override
    public Optional<Item> findById(Long id) {
        
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return Optional.ofNullable(this.client.build().get().uri("http://mscv-products/{id}" , params)
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(Item.class)
        .block());
    }

}
