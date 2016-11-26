package com.AristoPets.dao;

import com.AristoPets.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;



public interface UserRepository extends CrudRepository<User,Long> {
    @Override
    List<User> findAll();


    @Override
    User save(User user);


    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.authId = ?1")
    boolean isExists(String authId);

    @Query("select id FROM User where authId = ?1 ")
    long findIdByFacebookUserId(String authId);
}
