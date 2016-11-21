package com.AristoPets.services;

import com.AristoPets.dao.UserRepository;
import com.AristoPets.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User getUser(long id){
        return userDao.findOne(id);
    }
}
