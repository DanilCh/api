package com.AristoPets.entity;


import com.AristoPets.entity.enums.AuthType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "USER_TYPE")
    private boolean userType;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "NURSERY")
    private String nursery;

    @Column(name = "AUTH_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private AuthType authType;

    @Column(name = "AUTH_ID")
    private String authId;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "CLUB")
    private String club;

    @Column(name = "SOCIALS")
    private String socials;

    @Column(name = "PHOTO")
    private String photo;

    @Column(name = "CONTRACT_OF_SALE")
    private boolean contractOfSale;

    @Column(name = "ARCHIEVED")
    private boolean archieved;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @JsonBackReference
    private Set<Animal> animals;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @JsonBackReference
    private Set<Advert> adverts;


    public User() {
    }

    public User(boolean userType, String firstName, String lastName, String nursery, AuthType authType, String authId, String email, String phoneNumber, String club, String socials, String photo, boolean contractOfSale,  Set<Animal> animals) {
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nursery = nursery;
        this.authType = authType;
        this.authId = authId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.club = club;
        this.socials = socials;
        this.photo = photo;
        this.contractOfSale = contractOfSale;
        this.club = club;
        this.socials = socials;
        this.photo = photo;
        this.contractOfSale = contractOfSale;
        this.animals = animals;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isUserType() {
        return userType;
    }

    public void setUserType(boolean userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNursery() {
        return nursery;
    }

    public void setNursery(String nursery) {
        this.nursery = nursery;
    }

    public String getAuthType() {
        return authType.toString();
    }

    public void setAuthType(AuthType authType) {
        this.authType = authType;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getSocials() {
        return socials;
    }

    public void setSocials(String socials) {
        this.socials = socials;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isContractOfSale() {
        return contractOfSale;
    }

    public void setContractOfSale(boolean contractOfSale) {
        this.contractOfSale = contractOfSale;
    }


    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    public Set<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(Set<Advert> adverts) {
        this.adverts = adverts;
    }
}