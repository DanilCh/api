package com.AristoPets.entity;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ANIMAL_TYPE")
public class AnimalType implements Serializable{

    public enum Type {DOG,CAT};

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name ="A_TYPE")
    private Type type;

    public AnimalType() {
    }


}
