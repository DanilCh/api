package com.AristoPets.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "breeds")
public class Breed implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ANIMALTYPE_ID", nullable = false)
    private AnimalType animalType;

    public Breed() {
    }

    public Breed(String name, AnimalType animalType) {
        this.name = name;
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

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
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
