package com.AristoPets.controllers;

import com.AristoPets.dto.AnimalDto;
import com.AristoPets.entity.Advert;
import com.AristoPets.entity.Animal;
import com.AristoPets.entity.Breeds;
import com.AristoPets.services.AdvertService;
import com.AristoPets.services.AnimalService;
import com.AristoPets.services.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
public class ApiController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private BreedService  breedService;

    @Autowired
    private AdvertService advertService;

    @GetMapping("/api/breeds")
    public List<Breeds> getAllBreeds(){
        return breedService.findAll();
    }

    @GetMapping("/api/breeds/{id}")
    public Breeds getBreedById(@PathVariable("id") int id){
        return breedService.find(id);
    }


    @GetMapping("/api/adverts/all")
    public List<Advert> getAllAdverts(){ return advertService.findAll(); }

    @PostMapping("/api/animal/")
    public ResponseEntity<?> createAnimal(@RequestBody AnimalDto animal){
        if(animal == null){
            return ResponseEntity.noContent().build();
        }
        //TODO:validation of existing animal

        Animal result = animalService.saveAndFlush(animal);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("animal/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(location).body(result);
    }

/*    @PutMapping("/api/animal/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable("id") long id, @RequestBody Animal animal){

        Animal updatingAnimal = animalService.getAnimal(id);
    }*/
}
