package com.teclas.disney.controller;

import com.teclas.disney.model.entity.Actor;
import com.teclas.disney.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ActorController {
    @Autowired
    private ActorService actorService;



    //build create actor REST API
    @PostMapping("save")
    public ResponseEntity<Actor> saveActor(Actor actor){

        return new ResponseEntity<Actor>(actorService.saveActor(actor), HttpStatus.CREATED);
    }
    // build get all Actors REST API
    @GetMapping("/characters")
public List<Actor> getAllActors(){

        return actorService.getAllActors();
}

//build get actor by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Actor> getActoyById(@PathVariable("id") long actorid){
    return new ResponseEntity<Actor>(actorService.getActorById(actorid), HttpStatus.OK);
    }

    //build update actor REST API
    @PutMapping("{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable("id") long id , @RequestBody Actor actor){
        return new ResponseEntity<Actor>( actorService.updateActor(actor, id) , HttpStatus.OK);
    }

    //build delete Actor REST API
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteActor(@PathVariable ("id") long id){
        actorService.deleteActor(id);
        return new ResponseEntity<String>("Actor delete successfully", HttpStatus.OK);
    }
}
