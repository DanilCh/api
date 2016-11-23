package com.AristoPets.dao;

import com.AristoPets.entity.Breeds;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BreedsRepository extends CrudRepository<Breeds,Long> {

    @Override
    List<Breeds> findAll();

}
