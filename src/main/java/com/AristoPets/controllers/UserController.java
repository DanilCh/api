package com.AristoPets.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @RequestMapping("/user")
    public String getUserPage(){

        // here will be verification of user

        return "userP.html";
    }

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    @ResponseBody
    public boolean isUserBreeder(@RequestParam("usr") String user){
        return user.equals("breeder");

    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    @ResponseBody
    public void takeUserData(@RequestBody() String userInfo)  {



        //  ObjectMapper mapper = new ObjectMapper();
        // here will be great json serialization
        // System.out.println(userInfo);


    }
}
