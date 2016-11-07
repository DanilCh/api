package com.AristoPets.Hello.entity;

import java.util.Date;

public class Animal {
    private long id;
    private long breederID;
    private Date birthday;
    private Boolean readyForMating;
    private String photos;
    private String fullName;
    private String breed; //temporary type
    private String sex;
    private String colourOfAnimal;
    private String additionalInformation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBreederID() {
        return breederID;
    }

    public void setBreederID(long breederID) {
        this.breederID = breederID;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getReadyForMating() {
        return readyForMating;
    }

    public void setReadyForMating(Boolean readyForMating) {
        this.readyForMating = readyForMating;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getColourOfAnimal() {
        return colourOfAnimal;
    }

    public void setColourOfAnimal(String colourOfAnimal) {
        this.colourOfAnimal = colourOfAnimal;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }


}
