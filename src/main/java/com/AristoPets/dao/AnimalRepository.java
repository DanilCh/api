package com.AristoPets.dao;

import com.AristoPets.entity.Animal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AnimalRepository extends CrudRepository<Animal, Long> {

    @Query(value = "SELECT * FROM ANIMAL as a WHERE a.USER_ID = ?1",nativeQuery = true)
    List<Animal> findByUserID(long user_id);

}
