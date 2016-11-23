package com.AristoPets.dao;


import com.AristoPets.entity.Advert;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdvertsRepository extends CrudRepository<Advert,Long>{

    @Override
    List<Advert> findAll();

}
