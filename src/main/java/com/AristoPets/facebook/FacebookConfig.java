package com.AristoPets.facebook;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class FacebookConfig {

    @Value(value = "${appID}")
    private String appId;

    @Value(value = "${appSecret}")
    private String appSecret;

    public User getFaceBookUser(String facebookResponse) {

        JSONObject json = new JSONObject(facebookResponse);
        JSONObject authResponse = json.getJSONObject("authResponse");
        String accessToken = authResponse.getString("accessToken");

        FacebookClient facebookClient = new DefaultFacebookClient(accessToken, appSecret, Version.LATEST);

        User user = facebookClient.fetchObject("me", User.class, Parameter.with("fields", "id,name,email, first_name, last_name, picture.type(large)"));

        return user;

    }
}
