package com.AristoPets.entity;


import com.AristoPets.entity.enums.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ANIMALS")
public class Animal {


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

        @Column(name = "NURSERY")
        private String nursery;

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

        @RequestMapping(value = "/", method = RequestMethod.POST)
        public void getParam(@RequestParam String object){

        }




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

        public String getNursery() {
            return nursery;
        }

        public void setNursery(String nursery) {
            this.nursery = nursery;
        }

        public Set<Titles> getTitles() {
            return titles;
        }

        public void setTitles(Set<Titles> titles) {
            this.titles = titles;
        }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
