package com.AristoPets.facebook;

import com.AristoPets.entity.User;
import com.AristoPets.entity.UserCookie;
import com.AristoPets.entity.enums.AuthType;
import com.AristoPets.services.CookieService;
import com.AristoPets.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserAuthorization {


    @Autowired
    FacebookConfig facebookConfig;

    @Autowired
    UserService userService;

    @Autowired
    CookieService cookieService;


    public UserCookie userAuthorize(String facebookResponse) {

        com.restfb.types.User faceBookUser = facebookConfig.getFaceBookUser(facebookResponse);
        String facebookId = faceBookUser.getId();
        User user = userService.getUserByAuthId(facebookId);
        if (user != null) {
            cookieService.setCookie(user);
        } else {
            user = new User();
            user.setAuthId(facebookId);
            user.setUserType(false);
            user.setFirstName(faceBookUser.getFirstName());
            user.setLastName(faceBookUser.getLastName());
            user.setAuthType(AuthType.FB);
            user.setPhoto(faceBookUser.getPicture().getUrl());
            if (faceBookUser.getEmail() != null) {
                user.setEmail(faceBookUser.getEmail());
            } else user.setEmail("");
            userService.save(user);
            cookieService.setCookie(user);
        }
        return cookieService.getCookie(user.getId());
    }
}