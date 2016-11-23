package com.AristoPets.controllers;

import com.AristoPets.entity.Advert;
import com.AristoPets.entity.Animal;
import com.AristoPets.entity.Breeds;
import com.AristoPets.entity.User;
import com.AristoPets.services.AdvertServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class AdvertController {

    @Autowired
    private AdvertServiceImpl advertServiceImpl;

    @RequestMapping(value = "/advert",method = RequestMethod.GET)
    public String getAdvertPage(@RequestParam("id")long id, Model model){

        Advert advert = advertServiceImpl.getAdvert(id);
        User user = advert.getUser();
        Set<Breeds> breedsOfUser = user.getAnimals().stream().map(Animal::getBreed).collect(Collectors.toSet());
        model.addAttribute("name",user.getFirstName());
        model.addAttribute("lname",user.getLastName());
        model.addAttribute("nursery",user.getNursery());
        model.addAttribute("club",user.getClub());
        model.addAttribute("email",user.getEmail());
        model.addAttribute("phone",user.getPhoneNumber());
        model.addAttribute("breeds",breedsOfUser);
        model.addAttribute("contract",user.isContractOfSale());

        return "advert";
    }
}
