package com.AristoPets.services;

import com.AristoPets.dao.AnimalTypeDao;
import com.AristoPets.entity.AnimalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AnimalTypeService")
public class AnimalTypeServiceImpl implements AnimalTypeService {

    @Autowired
    AnimalTypeDao animalTypeDao;


    @Override
    public AnimalType findOne(long id) {
        return animalTypeDao.findOne(id);
    }

    @Override
    public Iterable<AnimalType> findAll() {
        return animalTypeDao.findAll();
    }
}
