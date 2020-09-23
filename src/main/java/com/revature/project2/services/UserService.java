package com.revature.project2.services;

import com.revature.project2.models.User;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserService implements Service<User> {

    // Comment

    public UserService() {
        System.out.println("UserService constructor");
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public Set<User> findAll() {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }


    // UserService should have all CRUD operations from Service interface AND authentication method

}
