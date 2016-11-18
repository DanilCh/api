package com.AristoPets.dao;

import com.AristoPets.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<User, Long> {
    @Override
    List<User> findAll();
}
