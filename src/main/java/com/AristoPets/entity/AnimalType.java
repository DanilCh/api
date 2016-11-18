package com.AristoPets.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "animal_type")
public class AnimalType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "A_TYPE")
    private String type;


    public AnimalType() {
    }

    public AnimalType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AnimalType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    public enum Type {DOG, CAT, DUCK;}
}
