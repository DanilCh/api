package com.AristoPets.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ANIMAL")
public class Animal {

    public enum Gender{ MALE, FEMALE }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "REGISTERED_NAME")
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "GENDER")
    private Gender gender;

    @Column(name = "COLOR")
    private String color;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "CLUB")
    private String club;

    @Column(name = "MORE_INFO")
    private String moreInfo;

    @ManyToOne
    @JoinColumn(name = "BREEDS_ID", nullable = false)
    private Breeds breed;

    @Column(name = "PHOTO")
    private String photo;

    @Column(name = "READY_TO_COPULATION",nullable = false)
    private int readyToCopulation;

    @OneToMany(mappedBy = "animalTitles",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Titles> titles;

    @ManyToOne
    @JoinColumn(name = "USER_ID",nullable = false)
    @JsonManagedReference
    private User user;

    //TODO : Make entity of advert and its handler
    @Transient
    private List<Advertisement> adverts;

    public Animal() {
    }

    public Animal(String name, Gender gender, String color, Date birthday,
                  String club, String moreInfo, Breeds breed, User user, String photo,
                  short readyToCopulation) {
        this.name = name;
        this.gender = gender;
        this.color = color;
        this.birthday = birthday;
        this.club = club;
        this.moreInfo = moreInfo;
        this.breed = breed;
        this.user = user;
        this.photo = photo;
        this.readyToCopulation = readyToCopulation;
    }

    public boolean isReadyToCopulation(){ return readyToCopulation!=0; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.birthday = dateFormat.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public Breeds getBreed() {
        return breed;
    }

    public void setBreed(Breeds breed) {
        this.breed = breed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Advertisement> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advertisement> adverts) {
        this.adverts = adverts;
    }

}
