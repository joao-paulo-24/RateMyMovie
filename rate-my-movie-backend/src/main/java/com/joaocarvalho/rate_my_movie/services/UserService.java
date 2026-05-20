package com.joaocarvalho.rate_my_movie.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joaocarvalho.rate_my_movie.exceptions.NotFoundException;
import com.joaocarvalho.rate_my_movie.models.User;
import com.joaocarvalho.rate_my_movie.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
    private final UserRepository repository;

    public List<User> getAllUsers () {
        return repository.findAll();
    }

    public User getUserByUsername (String username){
        return repository.findByUsername(username);
    }

    public User getUserByEmail (String email) {
        return repository.findByEmail(email);
    }

    public User getUserById (Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }

    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public User updateUser (Long id, User newUser){
        User user = repository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));

        user.setEmail(newUser.getEmail());
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());

        return repository.save(user);
    }

    public void deleteAllUsers() {
        repository.deleteAll();
    }

    public void deleteUserById(Long id){
        repository.deleteById(id);
    }

    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepository repository, BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
}
}
