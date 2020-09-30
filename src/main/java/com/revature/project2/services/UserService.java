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

    /**
     * CREATE operation
     * @param newUser
     * @return
     */
    @Transactional
    public User save(User newUser) {

        newUser.setRole(Role.USER);

        userRepo.save(newUser);

        return  newUser;
    }

    /**
     * READ operation
     * @return
     */
    @Transactional(readOnly=true)
    public List<User> findAll() {
        return userRepo.findAll();
    }

    /**
     * READ operation
     * @param id
     * @return
     */
    @Transactional(readOnly=true)
    public User findById(Integer id) {

        if (id <= 0) {
            throw new InvalidRequestException("ID cannot be negative or equal to zero");
        }

        return userRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    /**
     * READ operation
     * @param username
     * @param password
     * @return
     */
    @Transactional
    public User findUserByUsernameAndPassword(String username, String password) {

        return userRepo.findUserByUsernameAndPassword(username,password).orElseThrow(ResourceNotFoundException::new);

    }

    /**
     * UPDATE operation
     * @param updateUser
     * @return
     */
    @Transactional
    public boolean update(User updateUser){
        if(updateUser==null){
            return false;
        }
        return userRepo.update(updateUser);
    }

    /**
     * DELETE operation
     * @param id
     * @return
     */
    @Transactional
    public boolean deleteById(Integer id) {

        if (id <= 0) {
            throw new InvalidRequestException("ID cannot be negative or equal to zero");
        }

        return userRepo.deleteById(id);
    }

    /**
     * CREATE operation (creating a DTO)
     * @param creds
     * @return
     */
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