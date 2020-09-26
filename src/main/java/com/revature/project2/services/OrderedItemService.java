package com.revature.project2.services;

import com.revature.project2.models.OrderedItem;
import com.revature.project2.repos.OrderRepository;
import com.revature.project2.repos.OrderedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderedItemService {

    private OrderedItemRepository orderedItemRepo;

    @Autowired
    public OrderedItemService(OrderedItemRepository repo) {
        orderedItemRepo = repo;
    }

    @Transactional
    public Optional<OrderedItem> save(OrderedItem orderedItem) {
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    public Optional<OrderedItem> findById(Integer id) {
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    public List<OrderedItem> findAll() {
        return null;
    }

    @Transactional
    public boolean update(OrderedItem orderedItem) {
        return false;
    }

    @Transactional
    public boolean delete(OrderedItem orderedItem) {
        return false;
    }
}
