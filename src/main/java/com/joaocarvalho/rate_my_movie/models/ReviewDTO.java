package com.joaocarvalho.rate_my_movie.models;

public class ReviewDTO {
    private Long movieId;
    private Long userId;
    private String text;
    private int rating;
    
    public ReviewDTO(Long movieId, Long userId, String text, int rating) {
        this.movieId = movieId;
        this.userId = userId;
        this.text = text;
        this.rating = rating;
    }
    public Long getMovieId() {
        return movieId;
    }
    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
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
