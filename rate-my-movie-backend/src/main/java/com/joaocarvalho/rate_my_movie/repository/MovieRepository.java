package com.joaocarvalho.rate_my_movie.repository;

import com.joaocarvalho.rate_my_movie.models.Movie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long>{
    
    List<Movie> findByRating(int rating);

    List<Movie> findByTitle(String title);

    List<Movie> findByRatingGreaterThan(int rating);

    List<Movie> findByRatingLessThan(int rating);

}
