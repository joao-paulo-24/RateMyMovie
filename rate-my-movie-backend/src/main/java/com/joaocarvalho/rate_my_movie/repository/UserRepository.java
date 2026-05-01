package com.joaocarvalho.rate_my_movie.repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaocarvalho.rate_my_movie.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    User findByUsername (String username);

    User findByEmail (String email);

}
