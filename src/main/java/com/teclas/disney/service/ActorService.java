package com.teclas.disney.service;

import com.teclas.disney.model.Actor;

import java.util.List;

public interface ActorService {
    Actor saveActor(Actor actor);
    List<Actor> getAllActors();
    Actor getActorById(long id);
    Actor updateActor(Actor actor, long id);
    void deleteActor(long id);
}
