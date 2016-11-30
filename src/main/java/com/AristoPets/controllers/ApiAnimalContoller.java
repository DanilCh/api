package com.AristoPets.controllers;


import com.AristoPets.dto.AnimalDto;
import com.AristoPets.entity.Animal;
import com.AristoPets.entity.enums.UserType;
import com.AristoPets.services.AnimalService;
import com.AristoPets.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ApiAnimalContoller {

    @Autowired
    AnimalService animalService;

    @Autowired
    UserService userService;

    private final String redirectUri = "/breeder-registration";

    @PostMapping("/api/animal/")
    public ResponseEntity<?> createAnimal(@RequestBody AnimalDto animal) throws URISyntaxException {

        if(animal == null){
            return ResponseEntity.noContent().build();
        }

        if(userService.getUser(animal.getUserId()).getUserType() == UserType.BREEDER) {
            //TODO:validation of existing animal

            Animal result = animalService.saveAndFlush(animal);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("animal/{id}").buildAndExpand(result.getId()).toUri();
            return ResponseEntity.created(location).body(result);
        }
        else{
            return ResponseEntity.status(403).build();
        }
    }

    @PutMapping("/api/animal/")
    public ResponseEntity<Animal> updateAnimal(@RequestBody AnimalDto animal){

        Animal updatedAnimal = animalService.update(animal);;

        return ResponseEntity.ok(updatedAnimal);
    }
}
