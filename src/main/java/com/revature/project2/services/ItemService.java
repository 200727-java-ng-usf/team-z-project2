package com.revature.project2.services;

import com.revature.project2.models.Item;

import java.util.Set;

public class ItemService implements Service<Item> {

    public ItemService() {
        System.out.println("ItemService constructor");
    }


    @Override
    public Item save(Item item) {
        return null;
    }

    @Override
    public Item findById(Integer id) {
        return null;
    }

    @Override
    public Set<Item> findAll() {
        return null;
    }

    @Override
    public Item update(Item item) {
        return null;
    }

    @Override
    public Item delete(Item item) {
        return null;
    }
}
