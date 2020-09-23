package com.revature.project2.services;

import com.revature.project2.models.OrderedItem;

import java.util.Set;

public class OrderedItemService implements Service<OrderedItem> {

    public OrderedItemService() {
        System.out.println("OrderedItemService constructor");
    }


    @Override
    public OrderedItem save(OrderedItem orderedItem) {
        return null;
    }

    @Override
    public OrderedItem findById(Integer id) {
        return null;
    }

    @Override
    public Set<OrderedItem> findAll() {
        return null;
    }

    @Override
    public OrderedItem update(OrderedItem orderedItem) {
        return null;
    }

    @Override
    public OrderedItem delete(OrderedItem orderedItem) {
        return null;
    }
}
