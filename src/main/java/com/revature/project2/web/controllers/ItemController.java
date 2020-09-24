package com.revature.project2.web.controllers;

import com.revature.project2.models.Item;
import com.revature.project2.models.User;
import com.revature.project2.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController (ItemService itemService) { this.itemService = itemService; }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) // good practice to always include this even though it is set to JSON by default
    public List<Item> getAllItems() {
        return itemService.findAll();
    }

}
