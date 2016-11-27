package com.AristoPets.services;

import com.AristoPets.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User getUser(long id);
    User save(User user);
    User getUserByAuthId(String authId);
}
