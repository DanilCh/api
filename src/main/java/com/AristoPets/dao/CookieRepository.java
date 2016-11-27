package com.AristoPets.dao;


import com.AristoPets.entity.UserCookie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookieRepository extends JpaRepository<UserCookie,Long> {
    UserCookie findByUserId(long userId);
    UserCookie findByuuId(String uuId);
}
