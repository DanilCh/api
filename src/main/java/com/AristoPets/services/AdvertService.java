package com.AristoPets.services;


import com.AristoPets.entity.Advert;
import java.util.List;

public interface AdvertService {

    List<Advert> findAll();
    Advert getAdvert(long id);

}
