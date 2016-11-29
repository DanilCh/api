package com.AristoPets.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Breeds")
public class Breeds implements Serializable {

    public enum AnimalType{
        DOG, CAT
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ANIMAL_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private AnimalType animalType;

    public Breeds() {
    }

    public Breeds(long id, String name) {
        this.id = id;
        this.name = name;
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

    public AnimalType getAnimalType(){
        return animalType;
    }

    @Override
    public String toString() {
        return "Breeds{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", animalType=" + animalType +
                '}';
    }
}
