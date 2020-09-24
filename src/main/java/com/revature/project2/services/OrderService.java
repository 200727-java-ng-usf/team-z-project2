package com.revature.project2.services;

import com.revature.project2.models.Item;
import com.revature.project2.models.Order;
import com.revature.project2.repos.ItemRepository;
import com.revature.project2.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
}
