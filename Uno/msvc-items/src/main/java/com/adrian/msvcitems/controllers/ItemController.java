package com.adrian.msvcitems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.msvcitems.services.ItemService;

@RestController
public class ItemController {

    @Autowired
    private final ItemService itemService;

}
