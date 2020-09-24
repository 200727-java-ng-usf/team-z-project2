package com.revature.project2.services;

import com.revature.project2.models.Order;
import com.revature.project2.models.OrderedItem;
import com.revature.project2.repos.OrderRepository;
import com.revature.project2.repos.OrderedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class OrderedItemService {

    OrderedItemRepository orderedItemRepo;

    @Autowired
    public OrderedItemService(OrderedItemRepository orderedItemRepo) {
        this.orderedItemRepo = orderedItemRepo;
    }


    @Transactional(readOnly=true)
    public List<OrderedItem> findAll() {
        return orderedItemRepo.findAll();
    }
}
