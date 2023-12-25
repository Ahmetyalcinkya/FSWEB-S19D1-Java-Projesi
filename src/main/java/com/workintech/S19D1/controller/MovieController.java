package com.workintech.S19D1.controller;

import com.workintech.S19D1.dto.MovieResponse;
import com.workintech.S19D1.entity.Movie;
import com.workintech.S19D1.service.MovieService;
import com.workintech.S19D1.util.HollywoodValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("/")
    public List<MovieResponse> getAllMovies(){
        return movieService.getAllMovies();
    }
    @GetMapping("/{id}")
    public MovieResponse getMovie(long id){
        return movieService.getMovie(id);
    }
    @PostMapping("/")
    public MovieResponse saveMovie(@RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }
    @PutMapping("/{id}")
    public MovieResponse updateMovie(@PathVariable long id, @RequestBody Movie movie){
        HollywoodValidation.IDisNotValid(id);
        
        return movieService.updateMovie(movie);
    }
    @DeleteMapping("/{id}")
    public MovieResponse deleteMovie(@PathVariable long id){
        return movieService.deleteMovie(id);
    }
}
