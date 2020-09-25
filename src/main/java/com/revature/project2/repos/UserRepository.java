package com.revature.project2.repos;

import com.revature.project2.models.Role;
import com.revature.project2.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
        return session.createQuery("from User u where u.username = :un and u.password = :pw", User.class)
                .setParameter("un", username)
                .setParameter("pw", password)
                .getResultList()
                .stream().findFirst();
    }

    @Override
    public boolean update(User updateUser) {
        Session session = sessionFactory.getCurrentSession();
//        String hql = "update User u set u.username=:un,u.password=:pw,u.firstName=:fn,u.lastName=:ln,u.email=:e,u.role=:i where u.id= :id ";
//        session.createQuery(hql,User.class)
//                .setParameter("un",updateUser.getUsername())
//        .setParameter("pw",updateUser.getPassword())
//        .setParameter("fn",updateUser.getFirstName())
//        .setParameter("ln",updateUser.getLastName())
//        .setParameter("e",updateUser.getEmail())
//        .setParameter("i",updateUser.getRole())
//        .setParameter("id",updateUser.getId())
//       .executeUpdate();

        User target = session.get(User.class,updateUser.getId());
        target.setUsername(updateUser.getUsername());
        target.setEmail(updateUser.getEmail());
        target.setFirstName(updateUser.getFirstName());
        target.setLastName(updateUser.getLastName());
        target.setPassword(updateUser.getPassword());
        target.setRole(updateUser.getRole());
        if(updateUser==null && target ==null){
            return false;
        }else
        return  true;
    }

    @Override
    public boolean deleteById(Integer id) {

        Session session = sessionFactory.getCurrentSession();

            // Delete a persistent object
        User targetUser = session.get(User.class, id);
            if (targetUser != null) {
                session.delete(targetUser);
                return true;
            }

        return  false;
    }

    public boolean isEmailValid(String email){
        Session session = sessionFactory.getCurrentSession();
         return session.createQuery("from User u where u.email = :em ", User.class)
                .setParameter("em", email)
                .getResultList()
                .stream().findFirst().isPresent();
    }

    public boolean isUsernameValid(String username){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User u where u.username = :um ", User.class)
                .setParameter("um", username)
                .getResultList()
                .stream().findFirst().isPresent();
    }

    public Optional<User> findUserByUsername(String username){
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("from User u where u.username = :un", User.class)
                    .setParameter("un", username)
                    .getResultList()
                    .stream().findFirst();
        }

    public List<User> findUsersByRole(Role role) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User u where u.role = : r",User.class)
                .setParameter("r",role).getResultList();
    }




}

