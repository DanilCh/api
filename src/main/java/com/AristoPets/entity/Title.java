package com.AristoPets.entity;

import javax.persistence.*;

@Entity
@Table(name = "titles")
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "ANIMAL_ID", nullable = false)
    private Animal animal;

    public Title() {
    }

    public Title(String description, Animal animal) {
        this.description = description;
        this.animal = animal;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", animal=" + animal +
                '}';
    }
}
