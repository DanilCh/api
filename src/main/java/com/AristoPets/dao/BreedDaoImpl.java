package com.AristoPets.dao;

import com.AristoPets.entity.Breed;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class BreedDaoImpl implements BreedDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Breed find(long id) {
        String query = "SELECT b FROM Breed b WHERE b.id = :id";
        return entityManager.find(Breed.class,id);
    }

    @Override
    public List<Breed> findAll() {
        String query = "from Breed b";
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    public void update(Breed breed) {

        entityManager.merge(breed);

    }

    @Override
    public void updateAll(List<Breed> breedList) {
        for(Breed breed:breedList){
            entityManager.merge(breed);
        }
    }
}
