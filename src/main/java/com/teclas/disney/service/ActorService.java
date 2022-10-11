package com.teclas.disney.service;

import com.teclas.disney.model.entity.Actor;

import java.util.List;

public interface ActorService {
    Actor saveActor(Actor actor);
    List<Actor> getAllActors();
    Actor getActorById(Long id);
    Actor updateActor(Actor actor, Long id);
    void deleteActor(Long id);
}
