package com.AristoPets.facebook;

import com.AristoPets.entity.User;
import com.AristoPets.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserAuthorization {


    @Autowired
    FacebookConfig facebookConfig;

    @Autowired
    UserService userService;


    public long getUser(String response) {

        String accessToken = facebookConfig.getAccessToken(response);
        com.restfb.types.User faceBookUser = facebookConfig.getFaceBookUser(accessToken);

        System.out.println((userService.isExists(faceBookUser.getId());
        if (userService.isExists(faceBookUser.getId())) {

            updateUser(response);
        } else {
            createNewUser(response);
        }

        String facebookId = faceBookUser.getId();

        long userID = userService.findIdByFacebookUserId(facebookId);

        return userID;

    }


    public long createNewUser(String response) {

        User user = new User();
        String accessToken = facebookConfig.getAccessToken(response);
        com.restfb.types.User faceBookUser = facebookConfig.getFaceBookUser(accessToken);


        user.setAuthId(faceBookUser.getId());
        user.setUserType(true);
        user.setFirstName(faceBookUser.getFirstName());
        user.setLastName(faceBookUser.getLastName());
        user.setAuthType(true);
        user.setAuthId("1");
        if (faceBookUser.getEmail()!=null) {
            user.setEmail(faceBookUser.getEmail());
        } else  user.setEmail("test@,ail.ru");
        user.setPhoneNumber("2222");
        user.setClub("Club");
        user.setPhoto(faceBookUser.getPicture().getUrl());
        user.setContractOfSale(true);

        userService.save(user);

        long currentId = userService.findIdByFacebookUserId(faceBookUser.getId());

        return currentId;

    }

    public long updateUser(String response) {

        User user = new User();
        String accessToken = facebookConfig.getAccessToken(response);
        com.restfb.types.User faceBookUser = facebookConfig.getFaceBookUser(accessToken);

        long currentId = userService.findIdByFacebookUserId(faceBookUser.getId());

        user = userService.getUser(currentId);

        userService.save(user);

        return currentId;
    }
}
