package com.AristoPets.dao;

import com.AristoPets.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query(value = "SELECT * FROM ANIMALS a where a.user_id = 1?", nativeQuery = true)
    List<Animal> findByUserID(long userId);

}
