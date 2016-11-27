package com.AristoPets.services;

import com.AristoPets.dao.UserRepository;
import com.AristoPets.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UserService")
@Transactional
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

    @Override
    public User save(User user) { return userDao.saveAndFlush(user); }

    @Override
    public User getUserByAuthId(String authId) {
        return userDao.findByAuthId(authId);
    }


}
