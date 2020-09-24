package com.revature.project2.web.controllers;

import com.revature.project2.models.OrderedItem;
import com.revature.project2.services.OrderedItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ordereditems")
public class OrderedItemController {

    private OrderedItemService orderedItemService;

    @Autowired
    public OrderedItemController (OrderedItemService orderedItemService) { this.orderedItemService = orderedItemService; }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderedItem> getAllOrderedItems() { return orderedItemService.findAll(); }

}
