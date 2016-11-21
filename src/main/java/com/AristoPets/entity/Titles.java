package com.AristoPets.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "TITLES")
public class Titles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PHOTO")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "ANIMAL_ID", nullable = false)
    @JsonManagedReference
    private Animal animalTitles;

    public Titles(){
    }

    public Titles(String description, String photo, Animal animal) {
        this.description = description;
        this.photo = photo;
        this.animalTitles = animal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Animal getAnimalTitles() {
        return animalTitles;
    }

    public void setAnimalTitles(Animal animalTitles) {
        this.animalTitles = animalTitles;
    }
}
