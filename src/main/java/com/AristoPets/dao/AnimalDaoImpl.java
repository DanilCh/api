package com.AristoPets.dao;

import com.AristoPets.entity.Animal;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AnimalDaoImpl implements AnimalDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    EntityManager entityManager;

    public List<Animal> getAnimals() {
        Query query = entityManager.createQuery("from Animal");
        return query.getResultList();
    }

}
