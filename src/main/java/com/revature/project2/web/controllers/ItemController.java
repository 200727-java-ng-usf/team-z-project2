package com.revature.project2.web.controllers;

import com.revature.project2.models.Item;
import com.revature.project2.models.User;
import com.revature.project2.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController (ItemService itemService) { this.itemService = itemService; }

    // CREATE operation
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
//    public Item registerNewItem(@RequestBody Item newItem) {
//        return itemService.save(newItem);
//    }

    // READ operation
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) // good practice to always include this even though it is set to JSON by default
    public List<Item> getAllItems() {
        return itemService.findAll();
    }

    // READ operation
    // specify value param so that /items get request is not ambiguous
//    @GetMapping(value="id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Item getItemById (@PathVariable int id) { return itemService.findById(id); }

    // UPDATE operation
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PutMapping(value="id/{id}")
//    public Item updateItem (@PathVariable int id) { itemService.update(id); }

    // DELETE operation
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping(value="id/{id}")
//    public Item deleteItem (@PathVariable int id) { itemService.delete(id); }


}
