package com.AristoPets.services;

import com.AristoPets.dao.AnimalDaoImpl;
import com.AristoPets.entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AnimalService")
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private AnimalDaoImpl animalDaoImpl;

    @Override
    public List<Animal> getAnimals() {
        return animalDaoImpl.getAnimals();
    }
}
