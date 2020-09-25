package com.revature.project2.repos;

import com.revature.project2.models.Order;
import com.revature.project2.models.OrderedItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class OrderedItemRepository implements CrudRepository {


    private SessionFactory sessionFactory;

    public OrderedItemRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<OrderedItem> save(Object o) {
        return null;
    }

    @Override
    public Optional<OrderedItem> findById(Integer id) {
        return null;
    }

    @Override
    public List findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from OrderedItem", OrderedItem.class).getResultList();
    }

    @Override
    public boolean update(Object updateObj) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
