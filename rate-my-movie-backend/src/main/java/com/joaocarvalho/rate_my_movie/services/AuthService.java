package com.joaocarvalho.rate_my_movie.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.joaocarvalho.rate_my_movie.models.AuthResponse;
import com.joaocarvalho.rate_my_movie.models.LoginRequest;
import com.joaocarvalho.rate_my_movie.models.RegisterRequest;
import com.joaocarvalho.rate_my_movie.models.User;
import com.joaocarvalho.rate_my_movie.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder;
    private final JwtService jwtService;

    public AuthService(UserRepository repo, BCryptPasswordEncoder encoder, JwtService jwtService) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    public AuthResponse register(RegisterRequest req) {

        if (repo.findByEmail(req.getEmail()) != null) {
            throw new RuntimeException("Email já existe");
        }

        if (repo.findByUsername(req.getUsername()) != null) {
            throw new RuntimeException("Email já existe");
        }

        User user = new User();
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPassword(encoder.encode(req.getPassword()));

        repo.save(user);

        String token = jwtService.generateToken(user);

        return new AuthResponse(
                token,
                user.getId(),
                user.getUsername(),
                user.getEmail());
    }

    public AuthResponse login(LoginRequest req) {

        User user = repo.findByEmail(req.email);

        if (user == null || !encoder.matches(req.password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user);

        return new AuthResponse(
                token,
                user.getId(),
                user.getUsername(),
                user.getEmail());
    }
}