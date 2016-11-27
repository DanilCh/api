package com.AristoPets.services;

import com.AristoPets.dao.AnimalRepository;
import com.AristoPets.entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AnimalServiceImpl implements AnimalService {


    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public void saveOrUpdate(Animal animal) {
        animalRepository.save(animal);
    }

    @Override
    public void saveOrUpdateAll(List<Animal> animals) {
        animalRepository.save(animals);
    }

    @Override
    public List<Animal> getAnimalsByUserID(long id) {
        return animalRepository.findByUserID(id);
    }

    @Override
    public Animal getAnimal(long id) {
        return animalRepository.findOne(id);
    }
}
