package com.AristoPets.controllers;

import com.AristoPets.entity.Animal;
import com.AristoPets.entity.User;
import com.AristoPets.services.AnimalService;
import com.AristoPets.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnimalController {

    @Autowired
    private AnimalService animalService;


    @RequestMapping(value = "/animal", method = RequestMethod.GET)
    public String getAnimalPage(@RequestParam("id")long id,Model model){

        Animal animal;
        animal = animalService.getAnimal(id);
        User user = animal.getUser();
        model.addAttribute("name",user.getFirstName());
        model.addAttribute("lname",user.getLastName());
        model.addAttribute("nursery",user.getNursery());
        model.addAttribute("club",user.getClub());
        model.addAttribute("email",user.getEmail());
        model.addAttribute("phone",user.getPhoneNumber());
        model.addAttribute("animalName", animal.getName());//
        model.addAttribute("breed", animal.getBreed().getName());
        model.addAttribute("gender", animal.getGender().toString());
        model.addAttribute("color", animal.getColor());
        model.addAttribute("club", animal.getClub());
        model.addAttribute("birthday", animal.getBirthday());

        return "animal";
    }


}
