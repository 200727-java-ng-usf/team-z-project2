package com.revature.project2.services;

import com.revature.project2.models.User;
import com.revature.project2.repos.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }



    @Transactional(readOnly=true)
    public List<User> findAll() {
        return userRepo.findAll();
    }



    // UserService should have all CRUD operations from Service interface AND authentication method

}
