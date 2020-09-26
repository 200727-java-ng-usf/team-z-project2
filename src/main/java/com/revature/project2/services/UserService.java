package com.revature.project2.services;

import com.revature.project2.exceptions.AuthenticationException;
import com.revature.project2.exceptions.InvalidRequestException;
import com.revature.project2.exceptions.ResourceNotFoundException;
import com.revature.project2.models.Role;
import com.revature.project2.models.User;
import com.revature.project2.repos.UserRepository;
import com.revature.project2.web.dtos.Credentials;
import com.revature.project2.web.dtos.Principal;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    @Transactional(readOnly=true)
    public User findById(Integer id) {
        return userRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional
    public User save(User newUser) {

        newUser.setRole(Role.USER);

        userRepo.save(newUser);

        return  newUser;
    }

    @Transactional
    public boolean update(User updateUser){
        if(updateUser==null){
            return false;
        }
        return userRepo.update(updateUser);
    }

    @Transactional
    public boolean deleteById(Integer id) {
        return userRepo.deleteById(id);
    }
    @Transactional
    public User findUserByUsernameAndPassword(String username, String password) {

        return userRepo.findUserByUsernameAndPassword(username,password).orElseThrow(ResourceNotFoundException::new);

    }

    @Transactional
    public Principal authenticate (Credentials creds) {

        if (creds == null || creds.getUsername() == null || creds.getPassword() == null
                || creds.getUsername().equals("") || creds.getPassword().equals("")) {
            throw new InvalidRequestException("Invalid credentials object provided!");
        }

        try {

            User authUser = userRepo.findUserByUsernameAndPassword(creds.getUsername(), creds.getPassword())
                    .orElseThrow(AuthenticationException::new);

            return new Principal(authUser);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}