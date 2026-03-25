package com.joaocarvalho.rate_my_movie.repository;

import com.joaocarvalho.rate_my_movie.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long>{
    


}
