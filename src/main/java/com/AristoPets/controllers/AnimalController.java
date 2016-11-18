package com.AristoPets.controllers;

import com.AristoPets.entity.Animal;
import com.AristoPets.entity.AnimalType;
import com.AristoPets.services.AnimalService;
import com.AristoPets.services.AnimalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @Autowired
    AnimalTypeService animalTypeService;

   /* @RequestMapping(value = "/animal/", method = RequestMethod.GET)
    @ResponseBody
    public Animal getAnimalData(@RequestParam(value = "id") String id,
                                @RequestParam(value = "name") String name){
        //TODO: render of animal info and json serialization
        Animal animal = new Animal();
        animal.setFullName(name);

        return animal;
    }*/

    @RequestMapping(value = "/animals", method = RequestMethod.GET)
    public String getAnimalPage(Model model) {
        List<Animal> animals = animalService.getAnimals();
        Animal animal = animals.get(0);
        model.addAttribute("animal", animal);
        return "index";
    }

    @RequestMapping(value = "/animalstype", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String getAnimalTypePage(@RequestParam("num") int animalNum, Model model) {
        AnimalType animalType = animalTypeService.findOne(animalNum);
        model.addAttribute("animal", animalType);
        return "index";
    }

}
