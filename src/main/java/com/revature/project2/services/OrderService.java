package com.revature.project2.services;

import com.revature.project2.models.Order;

import java.util.Set;

public class OrderService implements Service<Order> {

    public OrderService() {
        System.out.println("OrderService constructor");
    }


    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public Order findById(Integer id) {
        return null;
    }

    @Override
    public Set<Order> findAll() {
        return null;
    }

    @Override
    public boolean update(Order order) {
        return false;
    }

    @Override
    public boolean delete(Order order) {
        return false;
    }
}
