package com.workintech.S19D1.service;

import com.workintech.S19D1.dto.ActorResponse;
import com.workintech.S19D1.dto.MovieReq;
import com.workintech.S19D1.entity.Actor;
import com.workintech.S19D1.entity.Movie;

import java.util.List;

public interface ActorService {

    List<ActorResponse> allActors();
    ActorResponse findActorByID(long id);
    ActorResponse saveActor(Actor actor);
    ActorResponse updateActor(long id, MovieReq movie);
    ActorResponse deleteActor(long id);
}
