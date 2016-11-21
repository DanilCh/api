package com.AristoPets.controllers;

import com.AristoPets.entity.Animal;
import com.AristoPets.entity.Breeds;
import com.AristoPets.services.AnimalService;
import com.AristoPets.services.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class ApiController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private BreedService  breedService;


    @RequestMapping("/api/breeds")
    public List<Breeds> getAllBreeds(){
        return breedService.findAll();
    }

    @RequestMapping("/api/breeds/{id}")
    public Breeds getBreedById(@PathVariable("id") int id){
        return breedService.find(id);
    }


    @RequestMapping("/api/animal/all")
    public Animal getAnimalsData(@RequestParam(value = "id") long id){

        Animal animal = animalService.getAnimal(id);
        return animal   ;
    }
}
