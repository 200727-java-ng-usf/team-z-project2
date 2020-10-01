package com.revature.project2.services;

import com.revature.project2.exceptions.InvalidRequestException;
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

    /**
     * CREATE operation
     * @param newOrder
     * @return
     */
    @Transactional
    public Order save(Order newOrder) {
        newOrder.setTimeCreated(new Timestamp(System.currentTimeMillis()));
        newOrder.setClosed(false);
        return orderRepo.save(newOrder).orElseThrow(ResourceNotFoundException::new);
    }

    /**
     * READ operation
     * @return
     */
    @Transactional(readOnly=true)
    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    /**
     * READ operation
     * @param id
     * @return
     */
    @Transactional
    public Order findById(Integer id) {

        if (id <= 0) {
            throw new InvalidRequestException("ID cannot be negative or equal to zero");
        }

        return orderRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    /**
     * READ operation
     * @param id
     * @return
     */
    @Transactional
    public List<Order> findAllByUser(int id) {

        if (id <= 0) {
            throw new InvalidRequestException("ID cannot be negative or equal to zero");
        }
        return orderRepo.findAllByUser(id);
    }

    /**
     * READ operation. (What is this?)
     * @param user
     * @return
     */
    @Transactional
    public Order findUserByUser(User user) {
        return orderRepo.findUserByUser(user).orElseThrow(ResourceNotFoundException::new);
    }

    /**
     * UPDATE operation
     * @param updateOrder
     * @return
     */
    @Transactional
    public boolean update(Order updateOrder) {
        return orderRepo.update(updateOrder);
    }

    /**
     * DELETE operation
     * @param id
     * @return
     */
    @Transactional
    public boolean deleteById(Integer id) {

        if (id <= 0) {
            throw new InvalidRequestException("ID cannot be negative or equal to zero");
        }

        return orderRepo.deleteById(id);
    }




}