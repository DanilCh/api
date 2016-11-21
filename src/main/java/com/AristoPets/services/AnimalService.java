package com.AristoPets.services;

import com.AristoPets.entity.Animal;

import java.util.List;


public interface AnimalService {
    void saveOrUpdate(Animal animal);
    void saveOrUpdateAll(List<Animal> animals);
    List<Animal> getAnimalsByUserID(long id);
    Animal getAnimal(long id);

}
