package com.joaocarvalho.rate_my_movie.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    private String poster;
    
    @Min(value = 0, message = "Rating must be >= 0")
    @Max(value = 10, message = "Rating must be <= 10")
    private int rating;

    public Movie() {}

    public Movie(String title, String poster, int rating){
        this.title = title;
        this.poster = poster;
        this.rating = rating;
    }

    public Long getId () { return this.id; }

    public String getTitle() { return this.title; }
    public void setTitle(String title) { this.title = title; }

    public String getPoster() { return this.poster; }
    public void setPoster(String poster) { this.poster = poster; }

    public int getRating() { return this.rating; }
    public void setRating(int rating) { this.rating = rating; }
    
}
