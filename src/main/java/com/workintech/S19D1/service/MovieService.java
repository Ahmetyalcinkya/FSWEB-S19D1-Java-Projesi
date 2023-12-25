package com.workintech.S19D1.service;

import com.workintech.S19D1.dto.MovieResponse;
import com.workintech.S19D1.entity.Movie;

import java.util.List;

public interface MovieService {

    List<MovieResponse> getAllMovies();
    MovieResponse getMovie(long id);
    MovieResponse saveMovie(Movie movie);
    MovieResponse updateMovie(Movie movie);
    MovieResponse deleteMovie(long id);
}
