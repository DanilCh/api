package com.AristoPets.dao;

import com.AristoPets.entity.Breed;

import java.util.List;

public interface BreedDao {
    Breed find(long id);

    List<Breed> findAll();

    void update(Breed breed);

    void updateAll(List<Breed> breedList);
}
