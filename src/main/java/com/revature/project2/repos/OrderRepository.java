package com.revature.project2.repos;


import com.revature.project2.models.Item;
import com.revature.project2.models.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository implements CrudRepository<Order> {

    private SessionFactory sessionFactory;

    public OrderRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<Order> save(Order order) {
        return null;
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Order", Order.class).getResultList();
    }

    @Override
    public boolean update(Order updateObj) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
