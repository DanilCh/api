package com.AristoPets.services;

import com.AristoPets.entity.AnimalType;

public interface AnimalTypeService {
    AnimalType findOne(long id);

    Iterable<AnimalType> findAll();
}
