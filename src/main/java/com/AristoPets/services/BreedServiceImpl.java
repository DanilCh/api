package com.AristoPets.services;

import com.AristoPets.dao.BreedDao;
import com.AristoPets.entity.Breed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service("BreedService")
public class BreedServiceImpl implements BreedService {

    private BreedDao breedDao;

    @Autowired
    protected BreedServiceImpl(BreedDao breedDao){
        this.breedDao = breedDao;
    }

    @Override
    public Breed find(long id) {
        Breed foundBreed;
        if(id>=0){
            foundBreed = breedDao.find(id);
        } else{
            return null;
        }

        return foundBreed;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Breed> findAll() {
        return breedDao.findAll();
    }

    @Override
    public void update(Breed breed) {
        breedDao.update(breed);
    }

    @Override
    public void updateAll(List<Breed> breedList) {
        breedDao.updateAll(breedList);

    }
}
