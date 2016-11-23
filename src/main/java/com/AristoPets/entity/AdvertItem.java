package com.AristoPets.entity;

import com.AristoPets.entity.enums.Gender;
import com.AristoPets.entity.enums.AdvertItemState;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "ADV_ITEMS")
public class AdvertItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "GENDER")
    private Gender gender;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "STATE")
    private AdvertItemState state;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "COLOR",nullable = false)
    private String color;

    @Column(name = "PHOTO")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "ADVERTS_ID",nullable = false)
    @JsonManagedReference
    private Advert advert;



    public AdvertItem() {
    }

    public AdvertItem(Gender gender, AdvertItemState state, int price, String color, String photo, Advert advert) {
        this.gender = gender;
        this.state = state;
        this.price = price;
        this.color = color;
        this.photo = photo;
        this.advert = advert;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public AdvertItemState getState() {
        return state;
    }

    public void setState(AdvertItemState state) {
        this.state = state;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }
}
