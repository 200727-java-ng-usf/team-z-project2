package com.revature.project2.repos;

import com.revature.project2.models.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class OrderRepository implements CrudRepository<Order> {


    @Override
    public Optional<Order> save(Order order) {
        return Optional.empty();
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Order> findAll() {
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
