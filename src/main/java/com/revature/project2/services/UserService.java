package com.revature.project2.services;

import com.revature.project2.models.User;
import com.revature.project2.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@org.springframework.stereotype.Service
public class UserService implements Service<User> {

    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository repo) {
        userRepo = repo;
    }


    @Override
    public Optional<User> save(User user) {
        return userRepo.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    @Transactional(readOnly=true) // transaction management from the service level
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    @Transactional
    public boolean update(User user) {
        return userRepo.update(user);
    }

    @Override
    public boolean delete(User user) {
        return userRepo.delete(user);
    }

}
