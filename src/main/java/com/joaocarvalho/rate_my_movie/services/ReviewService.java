package com.joaocarvalho.rate_my_movie.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joaocarvalho.rate_my_movie.exceptions.NotFoundException;
import com.joaocarvalho.rate_my_movie.models.Review;
import com.joaocarvalho.rate_my_movie.repository.ReviewRepository;

@Service
public class ReviewService {

    private final ReviewRepository repository;

    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public List<Review> getAllReviews() {
        return repository.findAll();
    }

    public Review getReviewById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Review not found"));
    }

    public List<Review> getReviewsByMovie(Long movieId) {
        return repository.findByMovieId(movieId);
    }

    public List<Review> getReviewsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public Review saveReview(Review review) {
        return repository.save(review);
    }

    public Review updateReview(Long id, Review newReview) {
        Review review = getReviewById(id);

        review.setText(newReview.getText());
        review.setRating(newReview.getRating());
        review.setMovie(newReview.getMovie());
        review.setUser(newReview.getUser());

        return repository.save(review);
    }

    public void deleteReview(Long id) {
        repository.deleteById(id);
    }
}