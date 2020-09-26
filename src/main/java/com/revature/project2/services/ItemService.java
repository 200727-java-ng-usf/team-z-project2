package com.revature.project2.services;

import com.revature.project2.models.Item;
import com.revature.project2.repos.ItemRepository;
import com.revature.project2.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ItemService {

    private ItemRepository itemRepo;

    @Autowired
    public ItemService(ItemRepository repo) {
        itemRepo = repo;
    }

    @Transactional
    public Optional<Item> save(Item item) {
        return itemRepo.save(item);
    }

    @Transactional(readOnly = true)
    public Optional<Item> findById(Integer id) {
        return itemRepo.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Item> findAll() {
        return itemRepo.findAll();
    }

    @Transactional
    public boolean update(Item item) {
        return itemRepo.update(item);
    }

    @Transactional
    public boolean delete(Item item) {
        return itemRepo.delete(item);
    }
}
