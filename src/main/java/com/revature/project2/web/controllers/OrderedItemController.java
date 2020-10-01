package com.revature.project2.web.controllers;

import com.revature.project2.models.OrderedItem;
import com.revature.project2.models.User;
import com.revature.project2.services.OrderedItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordereditems")
public class OrderedItemController {

    private OrderedItemService orderedItemService;

    @Autowired
    public OrderedItemController (OrderedItemService orderedItemService) { this.orderedItemService = orderedItemService; }

    // CREATE operation
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public OrderedItem registerNewOrderedItem (@RequestBody OrderedItem newOrderedItem) {
        return orderedItemService.save(newOrderedItem);
    }

    // READ operation
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderedItem> getAllOrderedItems() { return orderedItemService.findAll(); }

    // READ operation
    // specify value param so that /users get request is not ambiguous
    @GetMapping(value="id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderedItem getOrderedItemById (@PathVariable int id) { return orderedItemService.findById(id); }

    // UPDATE operation
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 = No Content
    @PutMapping
    public void updateOrderedItem (@RequestBody OrderedItem updatedOrderedItem) {

        orderedItemService.update(updatedOrderedItem); // need to change service-layer method to return void instead of boolean

    }

    // DELETE operation
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value="id/{id}")
    public void deleteOrderedItem (@PathVariable int id) { orderedItemService.deleteById(id); }


}
