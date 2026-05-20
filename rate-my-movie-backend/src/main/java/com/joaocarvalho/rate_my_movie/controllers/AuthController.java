package com.joaocarvalho.rate_my_movie.controllers;

import org.springframework.web.bind.annotation.*;

import com.joaocarvalho.rate_my_movie.services.AuthService;
import com.joaocarvalho.rate_my_movie.models.LoginRequest;
import com.joaocarvalho.rate_my_movie.models.RegisterRequest;
import com.joaocarvalho.rate_my_movie.models.AuthResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest req) {
        return service.register(req);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest req) {
        return service.login(req);
    }
}