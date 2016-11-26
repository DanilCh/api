package com.AristoPets.controllers;

import com.AristoPets.entity.Animal;
import com.AristoPets.entity.Breeds;
import com.AristoPets.entity.User;
import com.AristoPets.facebook.UserAuthorization;
import com.AristoPets.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    UserAuthorization userAuthorization;


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String getAnimalPage(@RequestParam(value = "param") String response, Model model) {

        long userId = userAuthorization.getUser(response);
        User user = userService.getUser(userId);

        Set<Breeds> breedsOfUser = user.getAnimals().stream().map(Animal::getBreed).collect(Collectors.toSet());
        Set<Animal> animals = user.getAnimals();





        model.addAttribute("name", user.getFirstName());
        model.addAttribute("lname", user.getLastName());
        model.addAttribute("photo", user.getPhoto());
        model.addAttribute("nursery", user.getNursery());
        model.addAttribute("club", user.getClub());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("phone", user.getPhoneNumber());
        model.addAttribute("social", user.getSocials());
        model.addAttribute("breeds",breedsOfUser);
        model.addAttribute("contract", user.isContractOfSale());
        model.addAttribute("animals", user.getAnimals());

        return "user";
    }
}
