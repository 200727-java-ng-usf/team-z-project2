package com.revature.project2.web.controllers;

import com.revature.project2.models.Order;
import com.revature.project2.models.User;
import com.revature.project2.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController (OrderService orderService) { this.orderService = orderService; }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) // good practice to always include this even though it is set to JSON by default
    public List<Order> getAllOrders() {
        return orderService.findAll();
    }

}
