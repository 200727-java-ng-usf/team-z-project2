package com.revature.project2.services;

import com.revature.project2.exceptions.ResourceNotFoundException;
import com.revature.project2.models.Item;
import com.revature.project2.models.Order;
import com.revature.project2.models.User;
import com.revature.project2.repos.ItemRepository;
import com.revature.project2.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    OrderRepository orderRepo;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepo = orderRepository;
    }


    @Transactional(readOnly=true)
    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    @Transactional
    public boolean update(Order updateOrder) {
        return orderRepo.update(updateOrder);
    }


    @Transactional
    public Order save(Order newOrder) {
        newOrder.setTimeCreated(new Timestamp(System.currentTimeMillis()));
        return orderRepo.save(newOrder).orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional
    public Order findById(Integer id) {
        return orderRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional
    public boolean deleteById(Integer id) {
        return orderRepo.deleteById(id);
    }

    @Transactional
    public Order findUserByUser(User user) {
        return orderRepo.findUserByUser(user).orElseThrow(ResourceNotFoundException::new);
    }


}