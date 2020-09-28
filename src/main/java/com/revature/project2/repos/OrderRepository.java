package com.revature.project2.repos;


import com.revature.project2.models.Item;
import com.revature.project2.models.Order;
import com.revature.project2.models.User;
import com.revature.project2.web.dtos.Principal;
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
    public Optional<Order> save(Order newOrder) {

        Session session = sessionFactory.getCurrentSession();
        session.save(newOrder);
        return Optional.of(newOrder);
    }

    @Override
    public Optional<Order> findById(Integer id) {

        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.get(Order.class, id));
    }

    @Override
    public List<Order> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Order", Order.class).getResultList();
    }

    public List<Order> findAllByUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        // select from orders table where user_id = principal.getId();
        return session.createQuery("from Order where user_id = " + id, Order.class).getResultList();
    }

    @Override
    public boolean update(Order updateOrder) {

        Session session = sessionFactory.getCurrentSession();
        Order target = session.get(Order.class,updateOrder.getId());
        target.setItemCount(updateOrder.getItemCount());
        target.setPrice(updateOrder.getPrice());
        target.setUser(updateOrder.getUser());
        if(updateOrder==null && target ==null){
            return false;
        }else
            return  true;

    }

    @Override
    public boolean deleteById(Integer id) {

        Session session = sessionFactory.getCurrentSession();

        // Delete a persistent object
        Order targetOrder = session.get(Order.class, id);
        if (targetOrder != null) {
            session.delete(targetOrder);
            return true;
        }

        return  false;
    }

    public Optional<Order> findUserByUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Order o where o.user = :u", Order.class)
                .setParameter("u", user)
                .stream().findFirst();
    }
}