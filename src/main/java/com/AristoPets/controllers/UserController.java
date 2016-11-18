package com.AristoPets.controllers;

import com.AristoPets.entity.User;
import com.AristoPets.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAnimalPage(Model model) {
        List<User> users = userService.findAll();
        User user = users.get(0);
        model.addAttribute("name", user.getFirstName());
        model.addAttribute("lname", user.getLastName());
        model.addAttribute("foto", user.getPhoto());
        model.addAttribute("nursery", user.getNursery());
        model.addAttribute("club", user.getClub());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("mob", user.getPhoneNumber());
        model.addAttribute("social", user.getSocials());
        model.addAttribute("animals", user.getAnimals());

        return "index";
    }
}
