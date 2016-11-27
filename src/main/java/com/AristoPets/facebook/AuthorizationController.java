package com.AristoPets.controllers;


import com.AristoPets.facebook.UserAuthorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorizationController {

    @Autowired
    private UserAuthorization userAuthorization;

    @RequestMapping(value = "/authorize", method = RequestMethod.POST)
    public void socialAuth(@RequestBody String facebookRequest){
        
    }

}
