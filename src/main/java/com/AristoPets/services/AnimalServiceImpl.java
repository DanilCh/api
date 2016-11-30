package com.AristoPets.services;

import com.AristoPets.dao.AnimalRepository;
import com.AristoPets.dao.BreedsRepository;
import com.AristoPets.dao.UserRepository;
import com.AristoPets.dto.AnimalDto;
import com.AristoPets.entity.Animal;
import com.AristoPets.entity.enums.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AnimalServiceImpl implements AnimalService {


    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    BreedsRepository breedsRepository;

    @Autowired
    UserRepository userRepository;



    @Override
    public List<Animal> getAnimalsByUserID(long id) {
        return animalRepository.findByUserID(id);
    }

    @Override
    public Animal saveAndFlush(Animal animal) {
        return animalRepository.saveAndFlush(animal);
    }

    @Override
    public Animal saveAndFlush(AnimalDto animalDto) {

        Animal animal = transferFromDtoToEntity(animalDto);

        return animalRepository.saveAndFlush(animal);
    }

    @Override
    public Animal update(AnimalDto animalDto) {
        Animal animal = transferFromDtoToEntity(animalDto);
        animal.setId(animalDto.getId());
        return animalRepository.save(animal);
    }

    @Override
    public Animal getAnimal(long id) {
        return animalRepository.findOne(id);
    }

    private Animal transferFromDtoToEntity(AnimalDto animalDto){
        Animal animal = new Animal();
        animal.setBreed(breedsRepository.getOne(animalDto.getBreedId()));
        animal.setBirthday(animalDto.getBirthday());
        animal.setClub(animalDto.getClub());
        animal.setGender(animalDto.getGender().toLowerCase().equals("male") ? Gender.MALE : Gender.FEMALE);
        animal.setColor(animalDto.getColor());
        animal.setName(animalDto.getName());
        animal.setUser(userRepository.getOne(animalDto.getUserId()));
        animal.setNursery(animalDto.getNursery());
        animal.setMoreInfo(animalDto.getMoreInfo());
        animal.setCopulationStatus(animalDto.isReadyToCopulation());
        //TODO:photos

        return animal;
    }
}
