package com.adrian.msvcitems.services;

import java.util.List;
import java.util.Optional;

import com.adrian.msvcitems.models.Item;

public interface ItemService {


    List<Item> findAll();

    Optional<Item> findById(Long id);

}
