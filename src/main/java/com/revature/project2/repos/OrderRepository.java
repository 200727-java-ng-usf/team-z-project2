package com.revature.project2.repos;

import com.revature.project2.models.Order;

import java.util.Set;

public class OrderRepository implements CrudRepository<Order> {
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
