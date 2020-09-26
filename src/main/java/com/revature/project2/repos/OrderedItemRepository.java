package com.revature.project2.repos;

import com.revature.project2.models.Item;
import com.revature.project2.models.Order;
import com.revature.project2.models.OrderedItem;
import com.revature.project2.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class OrderedItemRepository implements CrudRepository<OrderedItem> {


    private SessionFactory sessionFactory;

    public OrderedItemRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<OrderedItem> save(OrderedItem newOrderedItem) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newOrderedItem);
        return Optional.of(newOrderedItem);
    }

    @Override
    public Optional<OrderedItem> findById(Integer id) {

        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.get(OrderedItem.class, id));
    }

    @Override
    public List findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from OrderedItem", OrderedItem.class).getResultList();
    }

    @Override
    public boolean update(OrderedItem updateObj) {

        Session session = sessionFactory.getCurrentSession();
        OrderedItem target = session.get(OrderedItem.class,updateObj.getId());
        target.setItem(updateObj.getItem());
        target.setOrder(updateObj.getOrder());
        if(updateObj==null && target ==null){
            return false;
        }else
            return  true;

    }

    @Override
    public boolean deleteById(Integer id) {

        Session session = sessionFactory.getCurrentSession();

        // Delete a persistent object
        OrderedItem targetOrder = session.get(OrderedItem.class, id);
        if (targetOrder != null) {
            session.delete(targetOrder);
            return true;
        }
        return  false;
    }

    public List<OrderedItem> findOrderedItemsByItem(Item item) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from OrderedItem o where o.item = :i", OrderedItem.class)
                .setParameter("i", item)
                .getResultList();
    }

}
