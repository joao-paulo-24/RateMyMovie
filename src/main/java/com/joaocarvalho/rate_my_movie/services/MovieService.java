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
