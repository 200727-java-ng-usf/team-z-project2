package com.revature.project2.services;

import com.revature.project2.models.OrderedItem;
import com.revature.project2.repos.OrderRepository;
import com.revature.project2.repos.OrderedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@org.springframework.stereotype.Service
public class OrderedItemService implements Service<OrderedItem> {

    private OrderedItemRepository orderedItemRepo;

    @Autowired
    public OrderedItemService(OrderedItemRepository repo) {
        orderedItemRepo = repo;
    }

    @Override
    @Transactional
    public Optional<OrderedItem> save(OrderedItem orderedItem) {
        return Optional.empty();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrderedItem> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderedItem> findAll() {
        return null;
    }

    @Override
    @Transactional
    public boolean update(OrderedItem orderedItem) {
        return false;
    }

    @Override
    @Transactional
    public boolean delete(OrderedItem orderedItem) {
        return false;
    }
}
