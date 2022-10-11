package com.teclas.disney.service.impl;

import com.teclas.disney.exception.ResourceNotFoundException;
import com.teclas.disney.model.entity.Actor;
import com.teclas.disney.repository.ActorRepository;
import com.teclas.disney.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService {
    @Autowired
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
    public Actor getActorById(Long id) {

    return actorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Actor", "Id", id));
    }

    @Override
    public Actor updateActor(Actor actor, Long id) {
        Actor existingActor = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor", "Id", id));
        existingActor.setName(actor.getName());
        existingActor.setImage(actor.getImage());
        existingActor.setAge(actor.getAge());
        existingActor.setWeight(actor.getWeight());
        existingActor.setHistory(actor.getHistory());
        existingActor.setMovies(actor.getMovies()
                                     .stream()
                                     .collect(Collectors.toList()));
        actorRepository.save(existingActor);

        return existingActor;
    }

    @Override
    public void deleteActor(Long id) {
        //check whether an actor exist in DB or not
        actorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Actor", "Id", id));
        actorRepository.deleteById(id);

    }
}
