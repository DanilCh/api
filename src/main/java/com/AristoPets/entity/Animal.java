package com.AristoPets.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "REGISTERED_NAME")
    private String registeredName;

    @Column(name = "GENDER")
    private boolean gender;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "CLUB")
    private String club;

    @Column(name = "ADVERT_ID")
    private int advertID;

    @Column(name = "MORE_INFO")
    private String moreInfo;


    @Column(name = "PHOTO")
    private String photo;

    @Column(name = "READY_TO_COPULATION")
    private boolean readyToCopulation;

    @ManyToOne
    @JoinColumn(name = "BREEDS_ID", nullable = false)
    private Breed breed;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    public Animal() {
    }

    public Animal(String registeredName, boolean gender, String color, Date birthday, String club, int advertID, String moreInfo, String photo, boolean readyToCopulation, Breed breed, User user) {
        this.registeredName = registeredName;
        this.gender = gender;
        this.color = color;
        this.birthday = birthday;
        this.club = club;
        this.advertID = advertID;
        this.moreInfo = moreInfo;
        this.photo = photo;
        this.readyToCopulation = readyToCopulation;
        this.breed = breed;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegisteredName() {
        return registeredName;
    }

    public void setRegisteredName(String registeredName) {
        this.registeredName = registeredName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
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

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getAdvertID() {
        return advertID;
    }

    public void setAdvertID(int advertID) {
        this.advertID = advertID;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isReadyToCopulation() {
        return readyToCopulation;
    }

    public void setReadyToCopulation(boolean readyToCopulation) {
        this.readyToCopulation = readyToCopulation;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", registeredName='" + registeredName + '\'' +
                ", gender=" + gender +
                ", color='" + color + '\'' +
                ", birthday=" + birthday +
                ", club='" + club + '\'' +
                ", advertID=" + advertID +
                ", moreInfo='" + moreInfo + '\'' +
                ", photo='" + photo + '\'' +
                ", readyToCopulation=" + readyToCopulation +
                ", breed=" + breed +
                ", user=" + user +
                '}';
    }
}
