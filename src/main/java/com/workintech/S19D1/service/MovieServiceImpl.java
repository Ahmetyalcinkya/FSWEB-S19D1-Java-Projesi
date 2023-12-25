package com.workintech.S19D1.service;

import com.workintech.S19D1.dto.MovieResponse;
import com.workintech.S19D1.entity.Movie;
import com.workintech.S19D1.exceptions.HollywoodExceptions;
import com.workintech.S19D1.repository.MovieRepository;
import com.workintech.S19D1.util.Constants;
import com.workintech.S19D1.util.Converter;
import com.workintech.S19D1.util.HollywoodValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieResponse> getAllMovies() {
        return Converter.findMovies(movieRepository.findAll());
    }

    @Override
    public MovieResponse getMovie(long id) {
        HollywoodValidation.IDisNotValid(id);

        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if(optionalMovie.isPresent()){
            return Converter.findMovie(optionalMovie.get());
        }
        throw new HollywoodExceptions(Constants.ID_NOT_FOUND, HttpStatus.NOT_FOUND);
    }

    @Override
    public MovieResponse saveMovie(Movie movie) {
        HollywoodValidation.MovieExist(movieRepository.findAll(), movie);
        return Converter.findMovie(movieRepository.save(movie));
    }

    @Override
    public MovieResponse updateMovie(Movie movie) {
        HollywoodValidation.MovieIsNotExist(movieRepository.findAll(), movie);
        return Converter.findMovie(movieRepository.save(movie));
    }

    @Override
    public MovieResponse deleteMovie(long id) {
        HollywoodValidation.IDisNotValid(id);

        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()){
            return Converter.findMovie(movieOptional.get());
        }
        throw new HollywoodExceptions(Constants.ID_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
