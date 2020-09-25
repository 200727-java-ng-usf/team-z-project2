package com.revature.project2.services;

import com.revature.project2.exceptions.ResourceNotFoundException;
import com.revature.project2.models.Role;
import com.revature.project2.models.User;
import com.revature.project2.repos.UserRepository;
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
    public boolean isEmailValid(String email){
        return userRepo.isEmailValid(email);
    }

    @Transactional
    public boolean isUsernameValid(String username){
        return  userRepo.isUsernameValid(username);
    }

    @Transactional
    public List<User> findUsersByRole(String role) {
        Role roleEnum = Role.valueOf(role.toUpperCase());
        return userRepo.findUsersByRole(roleEnum);
    }

}
