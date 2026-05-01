package com.joaocarvalho.rate_my_movie.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.joaocarvalho.rate_my_movie.models.User;
import com.joaocarvalho.rate_my_movie.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    
    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return service.getUserByUsername(username);
    }

    
    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return service.getUserByEmail(email);
    }

    
    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return service.updateUser(id, user);
    }

    
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUserById(id);
    }

    
    @DeleteMapping
    public void deleteAllUsers() {
        service.deleteAllUsers();
    }
}