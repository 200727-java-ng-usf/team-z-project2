package com.revature.project2.repos;

import com.revature.project2.models.Item;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class ItemRepository implements CrudRepository<Item> {


    @Override
    public Optional<Item> save(Item item) {
        return null;
    }

    @Override
    public Optional<Item> findById(Integer id) {
        return null;
    }

    @Override
    public List<Item> findAll() {
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
