package com.workintech.S19D1.util;

import com.workintech.S19D1.entity.Actor;
import com.workintech.S19D1.entity.Movie;
import com.workintech.S19D1.exceptions.HollywoodExceptions;
import org.springframework.http.HttpStatus;

import java.util.List;

public class HollywoodValidation {

    public static void IDisNotValid(long id){
        if( id < 0) throw new HollywoodExceptions(Constants.ID_NOT_VALID, HttpStatus.BAD_REQUEST);
    }
    public static void ActorExist(List<Actor> actors, Actor actor){
        if (actors.contains(actor)) throw new HollywoodExceptions(Constants.ACTOR_EXIST, HttpStatus.BAD_REQUEST);
    }
    public static void ActorIsNotExist(List<Actor> actors, Actor actor){
        if (!actors.contains(actor)) throw new HollywoodExceptions(Constants.ACTOR_NOT_EXIST, HttpStatus.BAD_REQUEST);
    }
    public static void MovieExist(List<Movie> movies, Movie movie){
        if (movies.contains(movie)) throw new HollywoodExceptions(Constants.MOVIE_EXIST, HttpStatus.BAD_REQUEST);
    }
    public static void MovieIsNotExist(List<Movie> movies, Movie movie){
        if (!movies.contains(movie)) throw new HollywoodExceptions(Constants.MOVIE_NOT_EXIST, HttpStatus.BAD_REQUEST);
    }
}
