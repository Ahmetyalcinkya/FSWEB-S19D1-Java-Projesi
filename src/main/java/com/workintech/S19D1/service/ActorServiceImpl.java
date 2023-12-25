package com.workintech.S19D1.service;

import com.workintech.S19D1.dto.ActorResponse;
import com.workintech.S19D1.dto.MovieReq;
import com.workintech.S19D1.entity.Actor;
import com.workintech.S19D1.entity.Movie;
import com.workintech.S19D1.exceptions.HollywoodExceptions;
import com.workintech.S19D1.repository.ActorRepository;
import com.workintech.S19D1.util.Constants;
import com.workintech.S19D1.util.Converter;
import com.workintech.S19D1.util.HollywoodValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ActorServiceImpl implements ActorService {

    private ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<ActorResponse> allActors() {
        return Converter.findActors(actorRepository.findAll());
    }

    @Override
    public ActorResponse findActorByID(long id) {
        HollywoodValidation.IDisNotValid(id);

        Optional<Actor> actorOptional = actorRepository.findById(id);
        if(actorOptional.isPresent()){
            return Converter.findActor(actorOptional.get());
        }
        throw new HollywoodExceptions(Constants.ID_NOT_FOUND, HttpStatus.NOT_FOUND);
    }

    @Override
    public ActorResponse saveActor(Actor actor) {
        HollywoodValidation.ActorExist(actorRepository.findAll(), actor);
        return Converter.findActor(actorRepository.save(actor));
    }

    @Override
    public ActorResponse updateActor(long id, MovieReq movieReq) {
        HollywoodValidation.IDisNotValid(id);

//        Optional<Actor> actorOptional = actorRepository.findById(id);
//        if (actorOptional.isPresent()){
//            Actor foundActor = actorOptional.get();
//
//            for(Movie movie: foundActor.getMovies()){
//                if(movie.getName().equals(movieReq.getName())){
//                    throw new RuntimeException("This movie already added!");
//                }else {
//                    Movie movie1 = new Movie(movieReq.getId(), movieReq.getName(), movieReq.getDirectorName(),
//                            movieReq.getRating(), movieReq.getReleaseDate(),)
//                    foundActor.getMovies().add(movie1);
//                }
//            }
//        }
        return null;
    }

    @Override
    public ActorResponse deleteActor(long id) {
        HollywoodValidation.IDisNotValid(id);

        Optional<Actor> actorOptional = actorRepository.findById(id);
        if (actorOptional.isPresent()){
            actorRepository.delete(actorOptional.get());
        }
        throw new HollywoodExceptions(Constants.ID_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
