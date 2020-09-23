package com.revature.project2.repos;

import com.revature.project2.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class UserRepository implements CrudRepository<User> {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory factory) {
        sessionFactory = factory;
    }

    @Override
    public Optional<User> save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return Optional.of(user);
    }

    @Override
    public Optional<User> findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.of(session.get(User.class, id)); // get returns null; load throws an exception
    }

    public Optional<User> findUserByUsernameAndPassword(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.of(session.createQuery("from User u where u.username = :un and u.password = :pw", User.class)
                .setParameter("un", username)
                .setParameter("pw", password) // always use objects and field names for these queries, not table column names
                .getSingleResult());
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User", User.class).getResultList();
    }

    @Override
    public boolean update(User user) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.update(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.delete(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
