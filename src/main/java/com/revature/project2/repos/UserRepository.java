package com.revature.project2.repos;

import com.revature.project2.models.User;

import java.util.Set;

public class UserRepository implements CrudRepository<User> {

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
}
