package com.AristoPets.facebook;


import com.AristoPets.entity.UserCookie;
import com.AristoPets.services.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthorizationController {

    @Autowired
    private UserAuthorization userAuthorization;

    @Autowired
    private CookieService cookieService;

    private static final int COOKIE_AGE = 2693743;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String socialAuth(@RequestParam(value = "param") String facebookRequest, HttpServletResponse response){

        UserCookie nCoockie = userAuthorization.userAuthorize(facebookRequest);
        Cookie cookie = new Cookie("AristoPets",nCoockie.getUUID());
        cookie.setMaxAge(COOKIE_AGE);
        response.addCookie(cookie);

        return "redirect:/user";
    }

}
