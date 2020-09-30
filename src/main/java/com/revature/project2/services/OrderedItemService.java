package com.revature.project2.services;

import com.revature.project2.exceptions.InvalidRequestException;
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

    /**
     * CREATE operation
     * @param newOrderedItem
     * @return
     */
    @Transactional
    public OrderedItem save(OrderedItem newOrderedItem) {
        return orderedItemRepo.save(newOrderedItem).orElseThrow(ResourceNotFoundException::new);
    }

    /**
     * READ operation
     * @return
     */
    @Transactional(readOnly=true)
    public List<OrderedItem> findAll() {
        return orderedItemRepo.findAll();
    }

    /**
     * READ operation
     * @param id
     * @return
     */
    @Transactional
    public OrderedItem findById(Integer id) {

        if (id <= 0) {
            throw new InvalidRequestException("ID cannot be negative or equal to zero");
        }

        return orderedItemRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    /**
     * READ operation
     * @param item
     * @return
     */
    @Transactional
    public List<OrderedItem> findOrderedItemsByItem(Item item) {
        return orderedItemRepo.findOrderedItemsByItem(item);
    }

    /**
     * UPDATE operation
     * @param updateObj
     * @return
     */
    @Transactional
    public boolean update(OrderedItem updateObj) {
        return orderedItemRepo.update(updateObj);
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

        return orderedItemRepo.deleteById(id);
    }



}