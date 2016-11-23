package com.AristoPets.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ADVERTS")
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "BIRTHDAY", nullable = false)
    private Date birthday;

    @Column(name = "F_PARENT")
    private String fParentRef;

    @Column(name = "M_PARENT")
    private String mParentRef;

    @Column(name = "CLUB")
    private String club;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "F_VACCINATION")
    private String firstVaccination;

    @Column(name = "S_VACCINATION")
    private String secondVaccination;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    @JsonManagedReference
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "advert")
    @JsonBackReference
    private Set<AdvertItem> advertItems;

    //TODO:
    @Transient
    private String placeOfBirth;




    public Advert(){}

    public Advert(Date birthday, String fParentRef, String mParentRef, String club,
                  String description, String firstVaccination, String secondVaccination,
                  User user, Set<AdvertItem> advertItems, String placeOfBirth) {
        this.birthday = birthday;
        this.fParentRef = fParentRef;
        this.mParentRef = mParentRef;
        this.club = club;
        this.description = description;
        this.firstVaccination = firstVaccination;
        this.secondVaccination = secondVaccination;
        this.user = user;
        this.advertItems = advertItems;
        this.placeOfBirth = placeOfBirth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birhday) {
        this.birthday = birhday;
    }

    public String getfParentRef() {
        return fParentRef;
    }

    public void setfParentRef(String fParentRef) {
        this.fParentRef = fParentRef;
    }

    public String getmParentRef() {
        return mParentRef;
    }

    public void setmParentRef(String mParentRef) {
        this.mParentRef = mParentRef;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstVaccination() {
        return firstVaccination;
    }

    public void setFirstVaccination(String firstVaccination) {
        this.firstVaccination = firstVaccination;
    }

    public String getSecondVaccination() {
        return secondVaccination;
    }

    public void setSecondVaccination(String secondVaccination) {
        this.secondVaccination = secondVaccination;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<AdvertItem> getAdvertItems() {
        return advertItems;
    }

    public void setAdvertItems(Set<AdvertItem> advertItems) {
        this.advertItems = advertItems;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }
}
