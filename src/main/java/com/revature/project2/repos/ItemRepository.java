package com.revature.project2.repos;

import com.revature.project2.models.Item;
import com.revature.project2.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository implements CrudRepository<Item> {
    private SessionFactory sessionFactory;

    public ItemRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Comment
    @Override
    public Item save(Item item) {
        return null;
    }

    @Override
    public Item findById(Integer id) {
        return null;
    }

    @Override
    public List<Item> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Item", Item.class).getResultList();
    }

    @Override
    public boolean update(Item item) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
