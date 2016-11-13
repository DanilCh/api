package com.AristoPets.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Breed")
public class Breed implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ANIMAL_TYPE_ID")
    private AnimalType animalType;


    public Breed() {
    }

    public Breed(long id, String name, AnimalType animalType) {
        this.id = id;
        this.name = name;
        this.animalType = animalType;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Breed{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", animalType=" + animalType +
                '}';
    }
}
