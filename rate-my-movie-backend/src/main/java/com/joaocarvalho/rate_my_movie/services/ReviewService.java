package com.joaocarvalho.rate_my_movie.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joaocarvalho.rate_my_movie.exceptions.NotFoundException;
import com.joaocarvalho.rate_my_movie.models.Movie;
import com.joaocarvalho.rate_my_movie.models.Review;
import com.joaocarvalho.rate_my_movie.models.User;
import com.joaocarvalho.rate_my_movie.repository.MovieRepository;
import com.joaocarvalho.rate_my_movie.repository.ReviewRepository;
import com.joaocarvalho.rate_my_movie.repository.UserRepository;

@Service
public class ReviewService {

    private final ReviewRepository repository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    public ReviewService(ReviewRepository repository, MovieRepository mr, UserRepository ur) {
        this.repository = repository;
        this.movieRepository = mr;
        this.userRepository = ur;
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

    public Review saveReview(Long movieId, Long userId, String text, int rating) {

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Review review = new Review(movie, user, text, rating);

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