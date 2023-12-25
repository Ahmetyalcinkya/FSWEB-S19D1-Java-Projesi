package com.workintech.S19D1.controller;

import com.workintech.S19D1.dto.ActorResponse;
import com.workintech.S19D1.dto.MovieReq;
import com.workintech.S19D1.entity.Actor;
import com.workintech.S19D1.service.ActorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/actors")
public class ActorController {

    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/")
    public List<ActorResponse> getAllActors(){
        return actorService.allActors();
    }
    @GetMapping("/{id}")
    public ActorResponse getActorByID(@PathVariable long id){
        return actorService.findActorByID(id);
    }
    @PostMapping("/")
    public ActorResponse saveActor(@RequestBody Actor actor){
        return actorService.saveActor(actor);
    }
    @PutMapping("/{id}")
    public ActorResponse updateActor(@PathVariable long id, @RequestBody MovieReq actor){
        return actorService.updateActor(id,actor);
    }
    @DeleteMapping("/{id}")
    public ActorResponse deleteActor(@PathVariable long id){
        return actorService.deleteActor(id);
    }
}
