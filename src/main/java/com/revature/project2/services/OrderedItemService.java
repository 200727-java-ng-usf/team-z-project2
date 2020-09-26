package com.revature.project2.services;

import com.revature.project2.exceptions.ResourceNotFoundException;
import com.revature.project2.models.Item;
import com.revature.project2.models.Order;
import com.revature.project2.models.OrderedItem;
import com.revature.project2.models.User;
import com.revature.project2.repos.OrderRepository;
import com.revature.project2.repos.OrderedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class OrderedItemService {

    OrderedItemRepository orderedItemRepo;

    @Autowired
    public OrderedItemService(OrderedItemRepository orderedItemRepo) {
        this.orderedItemRepo = orderedItemRepo;
    }


    @Transactional(readOnly=true)
    public List<OrderedItem> findAll() {
        return orderedItemRepo.findAll();
    }


    @Transactional
    public OrderedItem save(OrderedItem newOrderedItem) {
        return orderedItemRepo.save(newOrderedItem).orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional
    public OrderedItem findById(Integer id) {
        return orderedItemRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional
    public List<OrderedItem> findOrderedItemsByItem(Item item) {
        return orderedItemRepo.findOrderedItemsByItem(item);
    }


    @Transactional
    public boolean update(OrderedItem updateObj) {
        return orderedItemRepo.update(updateObj);
    }

    @Transactional
    public boolean deleteById(Integer id) {
        return orderedItemRepo.deleteById(id);
    }



}