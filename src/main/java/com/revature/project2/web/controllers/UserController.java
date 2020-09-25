package com.revature.project2.web.controllers;

import com.revature.project2.models.User;
import com.revature.project2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // tells Spring this class is @Controller, and
// that each mapping method has an implied @ResponseBody on the return type
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    // constructor dependency injection
    @Autowired // don't need this annotation for constructor-injection
    public UserController (UserService userService) {
        this.userService = userService;
    }

    // CREATE operation
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public User registerNewUser(@RequestBody User newUser) {
        return userService.save(newUser);
    }

    // READ operation
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) // good practice to always include this even though it is set to JSON by default
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    // READ operation
    // specify value param so that /users get request is not ambiguous
    @GetMapping(value="id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById (@PathVariable int id) { return userService.findById(id); }

    // return void send back 204 no content
    // void return type on backend but 204 that you send back
    // boolean from repo layer to do validation in service layer, then do validation in service layer, but
    // returns void, not boolean

    // UPDATE operation
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PutMapping(value="id/{id}")
//    public void updateUser (@PathVariable int id) { userService.update(id); }

    // DELETE operation
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping(value="id/{id}")
//    public void deleteUser (@PathVariable int id) { userService.delete(id); }


}
