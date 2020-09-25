package com.revature.project2.repos;

import com.revature.project2.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class UserRepository implements CrudRepository<User> {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory factory) {
        this.sessionFactory = factory;
    }

    @Override
    public Optional<User> save(User newUser) {

        Session session = sessionFactory.getCurrentSession();
        session.save(newUser);
        return Optional.of(newUser);
    }

    @Override
    public Optional<User> findById(Integer id) {

        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.get(User.class, id));
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User",User.class).getResultList();
    }

    public Optional<User> findUserByUsernameAndPassword(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.of(session.createQuery("from User u where u.username = :un and au.password = :pw", User.class)
                .setParameter("un", username)
                .setParameter("pw", password)
                .getSingleResult());
    }

    @Override
    public boolean update(User updateUser) {

        if(updateUser==null) return false;

        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()){
            transaction = session.beginTransaction();
            User targetUser = session.get(User.class,updateUser.getId());

            if(targetUser==null){
                return false;
            }
            targetUser.setEmail(updateUser.getEmail());
            targetUser.setPassword(updateUser.getPassword());
            targetUser.setFirstName(updateUser.getFirstName());
            targetUser.setLastName(updateUser.getLastName());
            targetUser.setRole(updateUser.getRole());

            session.update(targetUser);
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return true;

    }

    @Override
    public boolean deleteById(Integer id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a persistent object
            User targetUser = session.get(User.class, id);
            if (targetUser != null) {
                session.delete(targetUser);
                return true;
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return  false;
    }
}
