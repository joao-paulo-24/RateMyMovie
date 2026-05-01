package com.joaocarvalho.rate_my_movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaocarvalho.rate_my_movie.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByMovieId(Long movieId);

    List<Review> findByUserId(Long userId);
}