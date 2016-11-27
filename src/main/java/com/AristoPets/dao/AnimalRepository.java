package com.AristoPets.dao;

import com.AristoPets.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByUserID(long user_id);

}
