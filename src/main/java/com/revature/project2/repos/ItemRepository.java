package com.revature.project2.repos;

import com.revature.project2.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ItemRepository implements CrudRepository<Item> {
    private SessionFactory sessionFactory;

    public ItemRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Comment
    @Override
    public Optional<Item> save(Item newItem) {

        Session session = sessionFactory.getCurrentSession();
        session.save(newItem);
        return Optional.of(newItem);

    }

    @Override
    public Optional<Item> findById(Integer id) {

        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.get(Item.class, id));
    }

    @Override
    public List<Item> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Item", Item.class).getResultList();
    }

    @Override
    public boolean update(Item updateItem) {

        Session session = sessionFactory.getCurrentSession();

        Item target = session.get(Item.class,updateItem.getId());
        target.setDescription(updateItem.getDescription());
        target.setGenre(updateItem.getGenre());
        target.setName(updateItem.getName());
        target.setPrice(updateItem.getPrice());
        target.setItemImageUrl(updateItem.getItemImageUrl());
        target.setStock(updateItem.getStock());
        if(updateItem==null && target ==null){
            return false;
        }else
            return  true;

    }

    @Override
    public boolean deleteById(Integer id) {

        Session session = sessionFactory.getCurrentSession();

        // Delete a persistent object
        Item targetItem = session.get(Item.class, id);
        if (targetItem != null) {
            session.delete(targetItem);
            return true;
        }

        return  false;
    }

    public List<Item> findUsersByGenre(Genre genre) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Item i where i.genre = : g",Item.class)
                .setParameter("g",genre).getResultList();
    }

    public Optional<Item> findUserByName(String name){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Item u where u.name = :n", Item.class)
                .setParameter("n", name)
                .getResultList()
                .stream().findFirst();
    }

    public boolean isNameValid(String name){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Item i where i.name = :n ", Item.class)
                .setParameter("n", name)
                .getResultList()
                .stream().findFirst().isPresent();
    }


}
