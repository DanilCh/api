package com.AristoPets.controllers;

import com.AristoPets.entity.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnimalController {


    @RequestMapping(value = "/animal/", method = RequestMethod.GET)
    @ResponseBody
    public Animal getAnimalData(@RequestParam(value = "id") String id,
                                @RequestParam(value = "name") String name){


        // here will be rendering of animal info and json serialization


        Animal animal = new Animal();
        animal.setFullName(name);

        return animal;
    }
    //// "/api/breeds"
    @RequestMapping("/animal")
    public String getAnimalPage(){
        return "animalP.html";
    }

}