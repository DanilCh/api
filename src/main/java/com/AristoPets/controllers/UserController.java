package com.AristoPets.controllers;

import com.AristoPets.entity.Animal;
import com.AristoPets.entity.Breeds;
import com.AristoPets.entity.User;
import com.AristoPets.facebook.FacebookConfig;
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
    FacebookConfig facebookConfig;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndexPage () {

        return "regestration";

    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String getAnimalPage(@RequestParam(value = "param") String response, Model model) {

        String accessToken = facebookConfig.getAccessToken(response);
        com.restfb.types.User faceBookUser = facebookConfig.getFaceBookUser(accessToken);

        System.out.println(faceBookUser.getPicture());

        User user = userService.getUser(1);
        Set<Breeds> breedsOfUser = user.getAnimals().stream().map(Animal::getBreed).collect(Collectors.toSet());
        model.addAttribute("name",  faceBookUser.getFirstName());
        model.addAttribute("lname",  faceBookUser.getLastName());
        model.addAttribute("photo", faceBookUser.getPicture().getUrl());
        model.addAttribute("nursery", user.getNursery());
        model.addAttribute("club", user.getClub());
        model.addAttribute("email", faceBookUser.getEmail());
        model.addAttribute("phone", user.getPhoneNumber());
        model.addAttribute("social", user.getSocials());
        model.addAttribute("breeds",breedsOfUser);
        model.addAttribute("contract",user.isContractOfSale());
        model.addAttribute("animals", user.getAnimals());

        return "index";
    }
}
