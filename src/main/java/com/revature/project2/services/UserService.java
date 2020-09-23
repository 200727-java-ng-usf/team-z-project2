package com.revature.project2.services;

import com.revature.project2.models.User;
import com.revature.project2.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository repo) {
        userRepo = repo;
    }

    public Optional<User> save(User user) {
        return userRepo.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }

    @Transactional(readOnly=true) // transaction management from the service level
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Transactional
    public boolean update(User user) {
        return userRepo.update(user);
    }

    public boolean delete(User user) {
        return userRepo.delete(user);
    }

}
