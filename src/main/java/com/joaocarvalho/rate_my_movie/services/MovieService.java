package com.joaocarvalho.rate_my_movie.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.joaocarvalho.rate_my_movie.exceptions.NotFoundException;
import com.joaocarvalho.rate_my_movie.models.Movie;
import com.joaocarvalho.rate_my_movie.repository.MovieRepository;

@Service
public class MovieService{
    private final MovieRepository repository;

    public MovieService(MovieRepository repository){
        this.repository = repository;
    }

    public List<Movie> getAllMovies() {
        return repository.findAll();
    }
    
    public Movie getMovieById(long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Movie not Found"));   
    }

    public List<Movie> getMoviesByRating(int rating){
        return repository.findByRating(rating);
    }

    public List<Movie> getMoviesByRatingGreaterThan(int rating){
        return repository.findByRatingGreaterThan(rating);
    }

     public List<Movie> getMoviesByRatingLowerThan(int rating){
        return repository.findByRatingLessThan(rating);
    }
    
    public List<Movie> getMoviesByTitle(String title){
        return repository.findByTitle(title);
    }
 
    public Movie saveMovie(Movie movie) {
        return repository.save(movie);
    }

    public Movie updateMovie(Long id, Movie newMovie) {
        Movie movie = repository.findById(id).orElseThrow(() -> new NotFoundException("Movie not Found"));

        movie.setPoster(newMovie.getPoster());
        movie.setTitle(newMovie.getTitle());
        movie.setRating(newMovie.getRating());

        return repository.save(movie);
    }

    public void deleteEveryMovie() {
        repository.deleteAll();
    }

    public void deleteMovieById(long id) {
        repository.deleteById(id);
    }

}
