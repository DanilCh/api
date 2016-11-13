package com.AristoPets.controllers;

import com.AristoPets.entity.Breed;
import com.AristoPets.services.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;;
import java.util.List;


@RestController
public class ApiController {

    @Autowired
    private BreedService  breedService;


    @RequestMapping("/api/breeds")
    public List<Breed> getAllBreeds(){
        return breedService.findAll();
    }

    @RequestMapping("/api/breeds/{id}")
    public Breed getBreedById(@PathVariable("id") int id){
        return breedService.find(id);
    }

}
