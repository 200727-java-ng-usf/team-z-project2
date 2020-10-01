package com.revature.project2.services;

import com.revature.project2.exceptions.InvalidRequestException;
import com.revature.project2.exceptions.ResourceNotFoundException;
import com.revature.project2.models.Item;
import com.revature.project2.models.Order;
import com.revature.project2.models.OrderedItem;
import com.revature.project2.repos.OrderedItemRepository;
import com.revature.project2.repos.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrderedItemServiceTest {

    private OrderedItemService orderedItemService;
    private OrderedItemRepository mockRepo = Mockito.mock(OrderedItemRepository.class);
    List<OrderedItem> mockItems = new ArrayList<>();

    @Before
    public void setUp() throws Exception {

       orderedItemService = new OrderedItemService(mockRepo);

       mockItems.add(new OrderedItem(1,new Order(),new Item()));

    }

    @After
    public void tearDown() throws Exception {
        orderedItemService = null;


    }

    @Test (expected = ResourceNotFoundException.class)
    public void save() {
        orderedItemService.save(null);

    }

    @Test
    public void findAll() {
       assertTrue(orderedItemService.findAll().isEmpty());
    }

    @Test (expected = InvalidRequestException.class)
    public void findById() {
        orderedItemService.findById(-2);
    }

    @Test
    public void findOrderedItemsByItem() {

        assertTrue(orderedItemService.findOrderedItemsByItem(null).isEmpty());
    }

    @Test
    public void update() {

        assertFalse(orderedItemService.update(null));
    }

    @Test (expected = InvalidRequestException.class)
    public void deleteById() {
        System.out.println(orderedItemService.deleteById(-21));
    }
}