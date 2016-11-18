package com.AristoPets.dao;

import com.AristoPets.entity.AnimalType;
import org.springframework.data.repository.CrudRepository;

public interface AnimalTypeDao extends CrudRepository<AnimalType, Long> {
}
