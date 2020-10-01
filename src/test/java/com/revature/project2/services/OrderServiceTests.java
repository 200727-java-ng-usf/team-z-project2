package com.revature.project2.services;

import com.revature.project2.exceptions.InvalidRequestException;
import com.revature.project2.exceptions.ResourceNotFoundException;
import com.revature.project2.models.Order;
import com.revature.project2.models.Role;
import com.revature.project2.models.User;
import com.revature.project2.repos.OrderRepository;
import com.revature.project2.repos.UserRepository;
import com.revature.project2.web.dtos.Credentials;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceTests {

    private OrderService sut;

    private OrderRepository mockOrderRepo = Mockito.mock(OrderRepository.class);
    List<Order> mockOrders = new ArrayList<>();

    @Before
    public void setup() {
        sut = new OrderService(mockOrderRepo);
        Timestamp timestamp = new Timestamp(1930, 4, 10, 8, 20, 20, 5);
        User user = new User(1, "Adam", "Inn", "admin", "secret", "admin@app.com", Role.ADMIN);
        mockOrders.add(new Order(timestamp, user, 13, 200.00, false));
        mockOrders.add(new Order(timestamp, user, 17, 300.00, false));
        mockOrders.add(new Order(timestamp, user, 22, 700.00, false));
        mockOrders.add(new Order(timestamp, user, 7, 70.00, false));
    }

    @After
    public void tearDown() {
        sut = null;
        mockOrders.removeAll(mockOrders);
    }

    @Test (expected = NullPointerException.class)
    public void registerWithNullObject() { sut.save(null); }

    @Test (expected = InvalidRequestException.class)
    public void getReimbByIdNegativeId() { sut.findById(-30); }


    @Test
    public void findAll() {
        Assert.assertTrue(sut.findAll().isEmpty());
    }

    @Test (expected = InvalidRequestException.class)
    public void findById() {
        sut.findById(-10);
    }

    @Test (expected = InvalidRequestException.class)
    public void findAllByUser() {
        sut.findAllByUser(-10);
    }

    @Test (expected = ResourceNotFoundException.class)
    public void findUserByUser() {

        sut.findUserByUser(null);
    }

    @Test
    public void update() {
        Assert.assertFalse(sut.update(null));
    }

    @Test (expected = InvalidRequestException.class)
    public void deleteById() {
        Assert.assertFalse(sut.deleteById(1));
        sut.deleteById(-99);
    }






}
