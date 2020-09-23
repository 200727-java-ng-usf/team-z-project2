package com.revature.project2.services;

import com.revature.project2.models.Order;
import com.revature.project2.repos.ItemRepository;
import com.revature.project2.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@org.springframework.stereotype.Service
public class OrderService implements Service<Order> {

    private OrderRepository orderRepo;

    @Autowired
    public OrderService(OrderRepository repo) {
        orderRepo = repo;
    }

    @Override
    @Transactional
    public Optional<Order> save(Order order) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Order> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return null;
    }

    @Override
    @Transactional
    public boolean update(Order order) {
        return false;
    }

    @Override
    @Transactional
    public boolean delete(Order order) {
        return false;
    }
}
