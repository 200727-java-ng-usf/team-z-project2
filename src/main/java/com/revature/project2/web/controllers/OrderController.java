package com.revature.project2.web.controllers;

import com.revature.project2.models.Order;
import com.revature.project2.models.User;
import com.revature.project2.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController (OrderService orderService) { this.orderService = orderService; }

    // CREATE operation
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Order registerNewOrder(@RequestBody Order newOrder) {
        return orderService.save(newOrder);
    }

    // READ operation
    // specify value param so that /orders get request is not ambiguous
    @GetMapping(value="id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrderById (@PathVariable int id) { return orderService.findById(id); }

    // READ operation
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) // good practice to always include this even though it is set to JSON by default
    public List<Order> getAllOrders() {
        return orderService.findAll();
    }

    // UPDATE operation
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 = No Content
    @PutMapping
    public void updateOrder (@RequestBody Order updatedOrder) {

        orderService.update(updatedOrder); // need to change service-layer method to return void instead of boolean

    }

    // DELETE operation
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value="id/{id}")
    public void deleteOrder (@PathVariable int id) { orderService.deleteById(id); }



}
