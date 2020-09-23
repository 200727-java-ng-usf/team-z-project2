package com.revature.project2.repos;

import com.revature.project2.models.Item;

import java.util.Set;

public class ItemRepository implements CrudRepository<Item> {
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
    public boolean update(Item item) {
        return false;
    }

    @Override
    public boolean delete(Item item) {
        return false;
    }
}
