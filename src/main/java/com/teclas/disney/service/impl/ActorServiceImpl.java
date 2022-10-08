package com.teclas.disney.service.impl;

import com.teclas.disney.exception.ResourceNotFoundException;
import com.teclas.disney.model.Actor;
import com.teclas.disney.repository.ActorRepository;
import com.teclas.disney.service.ActorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {
    private ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        super();
        this.actorRepository = actorRepository;
    }

    @Override
    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }


    @Override
    public Actor getActorById(long id) {

    return actorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Actor", "Id", id));
    }

    @Override
    public Actor updateActor(Actor actor, long id) {
        Actor existingActor = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor", "Id", id));
        existingActor.setName(actor.getName());
        existingActor.setImage(actor.getImage());
        existingActor.setAge(actor.getAge());
        existingActor.setWeight(actor.getWeight());
        existingActor.setHistory(actor.getHistory());
        existingActor.setAssociatedMovies(actor.getAssociatedMovies());
        actorRepository.save(existingActor);

        return existingActor;
    }

    @Override
    public void deleteActor(long id) {
        //check whether an actor exist in DB or not
        actorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Actor", "Id", id));
        actorRepository.deleteById(id);

    }
}
