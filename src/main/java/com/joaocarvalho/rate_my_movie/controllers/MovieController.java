package com.joaocarvalho.rate_my_movie.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaocarvalho.rate_my_movie.models.Movie;
import com.joaocarvalho.rate_my_movie.services.MovieService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public List<Movie> getMovies() {
        return service.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable long id){
        return service.getMovieById(id);
    }

    
    //@GetMapping{}

    @PostMapping
    public Movie createMovie (@Valid @RequestBody Movie movie){
        if (movie.getTitle().isBlank() || movie.getTitle().isEmpty() || 0 > movie.getRating() || 10 < movie.getRating()){
            return service.saveMovie(movie);
        }

        return null;
    }

    @PutMapping("/{id}")
    public Movie updateMovie (@PathVariable Long id,@RequestBody Movie newMovie) {

        if (newMovie.getTitle().isBlank() || newMovie.getTitle().isEmpty() || 0 > newMovie.getRating() || 10 < newMovie.getRating()){
            return service.updateMovie(id, newMovie);
        }

        return null;
    }

    @DeleteMapping
    public void removeAllMovies() {
        service.deleteEveryMovie();
    }

    @DeleteMapping("/{id}")
    public void removeMovieById(@PathVariable Long id) {
        service.deleteMovieById(id);
    }
}
