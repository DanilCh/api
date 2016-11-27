package com.AristoPets.controllers;

import com.AristoPets.entity.Animal;
import com.AristoPets.entity.Breeds;
import com.AristoPets.entity.User;
import com.AristoPets.services.CookieService;
import com.AristoPets.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    private CookieService cookieService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAnimalPage(@CookieValue(name = "AristoPets",required = false) String cookie, Model model) {
        if(cookie != null) {
            User user = cookieService.getCookie(cookie).getUser();
            Set<Animal> animals = user.getAnimals();
            Set<Breeds> breedsOfUser = user.getAnimals().stream().map(Animal::getBreed).collect(Collectors.toSet());
            model.addAttribute("name", user.getFirstName());
            model.addAttribute("lname", user.getLastName());
            model.addAttribute("photo", user.getPhoto());
            model.addAttribute("nursery", user.getNursery());
            model.addAttribute("club", user.getClub());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("phone", user.getPhoneNumber());
            model.addAttribute("social", user.getSocials());
            model.addAttribute("breeds", breedsOfUser);
            model.addAttribute("contract", user.isContractOfSale());
            model.addAttribute("animals", animals);
        }

        return "user";
    }
}
