package com.workintech.S19D1.util;

import com.workintech.S19D1.dto.ActorResponse;
import com.workintech.S19D1.dto.MovieResponse;
import com.workintech.S19D1.entity.Actor;
import com.workintech.S19D1.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    // ACTOR CONVERTER
    public static List<ActorResponse> findActors(List<Actor> actors){
        List<ActorResponse> actorResponses = new ArrayList<>();

        for(Actor actor: actors){
            actorResponses.add(new ActorResponse(actor.getFirstName(),
                    actor.getLastName(), actor.getGender(), actor.getBirthDate()));
        }
        return actorResponses;
    }
    public static ActorResponse findActor(Actor actor){
        return new ActorResponse(actor.getFirstName(), actor.getLastName(),
                actor.getGender(), actor.getBirthDate());
    }

    // MOVIE CONVERTER
    public static List<MovieResponse> findMovies(List<Movie> movies){
        List<MovieResponse> movieResponses = new ArrayList<>();

        for(Movie movie: movies){
            movieResponses.add(new MovieResponse(movie.getName(),
                    movie.getDirectorName(), movie.getRating(),
                    movie.getReleaseDate()));
        }
        return movieResponses;
    }
    public static MovieResponse findMovie(Movie movie){
        return new MovieResponse(movie.getName(), movie.getDirectorName(),
                movie.getRating(), movie.getReleaseDate());
    }
}
