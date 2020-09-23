package com.revature.project2.services;

import com.revature.project2.models.Item;
import com.revature.project2.repos.ItemRepository;
import com.revature.project2.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@org.springframework.stereotype.Service
public class ItemService implements Service<Item> {

    private ItemRepository itemRepo;

    @Autowired
    public ItemService(ItemRepository repo) {
        itemRepo = repo;
    }

    @Override
    @Transactional
    public Optional<Item> save(Item item) {
        return itemRepo.save(item);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Item> findById(Integer id) {
        return itemRepo.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Item> findAll() {
        return itemRepo.findAll();
    }

    @Override
    @Transactional
    public boolean update(Item item) {
        return itemRepo.update(item);
    }

    @Override
    @Transactional
    public boolean delete(Item item) {
        return itemRepo.delete(item);
    }
}
