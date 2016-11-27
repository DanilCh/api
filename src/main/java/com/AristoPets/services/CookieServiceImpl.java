package com.AristoPets.services;


import com.AristoPets.dao.CookieRepository;
import com.AristoPets.entity.User;
import com.AristoPets.entity.UserCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class CookieServiceImpl implements CookieService {

    @Autowired
    private CookieRepository cookieRepository;


    @Override
    public void setCookie(User user) {

        UserCookie userCookie = cookieRepository.findByUserId(user.getId());
        String uuID = UUID.randomUUID().toString();
        if (userCookie != null) {
            cookieRepository.delete(userCookie);
        }
        userCookie = new UserCookie();
        userCookie.setUser(user);
        userCookie.setUUID(uuID);
        cookieRepository.saveAndFlush(userCookie);
    }

    @Override
    public UserCookie getCookie(long userId) {
            return cookieRepository.findByUserId(userId);
    }

    @Override
    public UserCookie getCookie(String UUID) {

        return cookieRepository.findByuuId(UUID);
    }
}
