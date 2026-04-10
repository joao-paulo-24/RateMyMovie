package com.joaocarvalho.rate_my_movie.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.joaocarvalho.rate_my_movie.models.Review;
import com.joaocarvalho.rate_my_movie.services.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return service.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return service.getReviewById(id);
    }

    @GetMapping("/movie/{movieId}")
    public List<Review> getByMovie(@PathVariable Long movieId) {
        return service.getReviewsByMovie(movieId);
    }

    @GetMapping("/user/{userId}")
    public List<Review> getByUser(@PathVariable Long userId) {
        return service.getReviewsByUser(userId);
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return service.saveReview(review);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review review) {
        return service.updateReview(id, review);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        service.deleteReview(id);
    }
}