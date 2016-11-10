package com.AristoPets.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdvertController {

    @RequestMapping("/advert")
    public String getAdvertPage(){

        return "advertP.html";
    }
}
