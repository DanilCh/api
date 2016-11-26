package com.AristoPets.facebook;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.json.JsonObject;
import com.restfb.types.User;
import org.json.JSONObject;
import org.springframework.stereotype.Service;


@Service
public class FacebookConfig {


    public String getAccessToken(String response) {

        JSONObject json = new JSONObject(response);

        JSONObject authResponse = json.getJSONObject("authResponse");

        String accessToken = authResponse.getString("accessToken");
        int expiresIn = authResponse.getInt("expiresIn");
        String userID = authResponse.getString("userID");
        String signedRequest = authResponse.getString("signedRequest");

        return accessToken;

    }
    public  FacebookClient getFacebookClient(String accessToken) {

        String appId = "372236016446842";
        String appSecret = "4ed6f36178779c9d2c63ca0bb5654f21";

        FacebookClient facebookClient = new DefaultFacebookClient(accessToken, appSecret, Version.VERSION_2_8);
        return facebookClient;

    }

    public User getFaceBookUser(String accessToken) {
        String appId = "372236016446842";
        String appSecret = "4ed6f36178779c9d2c63ca0bb5654f21";

        FacebookClient facebookClient = new DefaultFacebookClient(accessToken, appSecret, Version.VERSION_2_8);



        /*

                     GETTING EXTENDED ACCESS TOKEN

        FacebookClient.AccessToken extendedAccessToken = facebookClient.obtainExtendedAccessToken(appId, appSecret, accessToken);
        String extendedAccessTokenString = extendedAccessToken.getAccessToken();
        FacebookClient facebookClientWithExtendedAccessToken = new DefaultFacebookClient(extendedAccessTokenString, appSecret, Version.VERSION_2_8);
        User userWithExtenderAccessToken = facebookClientWithExtendedAccessToken.fetchObject("me", User.class, Parameter.with("fields", "id,name,email"));
        JsonObject fetchObjectsResults = facebookClientWithExtendedAccessToken.fetchObject("me", JsonObject.class, Parameter.with("fields", "id,name,email"));


        */

        User user = facebookClient.fetchObject("me", User.class, Parameter.with("fields", "id,name,email, first_name, last_name, picture.type(large)"));

        JsonObject fetchObjectsResults = facebookClient.fetchObject("me", JsonObject.class, Parameter.with("fields", "id,name,email, first_name, last_name"));


        return user;

    }
}
