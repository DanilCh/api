package com.AristoPets.services;

import com.AristoPets.dto.AnimalDto;
import com.AristoPets.entity.Animal;

import java.util.List;


public interface AnimalService {
    Animal saveOrUpdate(Animal animal);
    void saveOrUpdateAll(List<Animal> animals);
    List<Animal> getAnimalsByUserID(long id);
    Animal saveAndFlush(Animal animal);
    Animal saveAndFlush(AnimalDto animalDto);
    Animal getAnimal(long id);
}
