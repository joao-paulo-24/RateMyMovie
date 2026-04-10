package com.joaocarvalho.rate_my_movie.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "movie", nullable = false)
    @ManyToOne
    private Movie movie;

    @Column(name = "user", nullable = false)
    @ManyToOne
    private User user;

    @Column(name = "text", nullable = true)
    private String text;

    @Column(name = "rating", nullable = true)
    @Min(value = 0, message = "Rating must be >= 0")
    @Max(value = 10, message = "Rating must be <= 10")
    private int rating;

    

    public Review(Movie movie, User user, String text,
            @Min(value = 0, message = "Rating must be >= 0") @Max(value = 10, message = "Rating must be <= 10") int rating) {
        this.movie = movie;
        this.user = user;
        this.text = text;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    

}
