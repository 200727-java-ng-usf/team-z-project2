package com.revature.project2.services;

import com.revature.project2.models.Item;
import com.revature.project2.models.User;
import com.revature.project2.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    ItemRepository itemRepo;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepo = itemRepository;
    }


    @Transactional(readOnly=true)
    public List<Item> findAll() {
        return itemRepo.findAll();
    }
}
