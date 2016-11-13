package com.AristoPets.services;

import com.AristoPets.entity.Breed;

import java.util.List;



public interface BreedService {
    Breed find(long id);
    List<Breed> findAll();
    void update(Breed breed);
    void updateAll(List<Breed> breedList);
}
