package com.AristoPets.Hello.entity;

public class User {
    private long id;
    private String outhType; // String type is temporary
    private String outhId; // String type is temporary
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String skypeAccount;
    private String nursery;
    private String nurseryAddress;
    private String club;
    private String agreement;
    private String animalsBreed; // String type is temporary

    public String getAnimalsBreed() {
        return animalsBreed;
    }

    public void setAnimalsBreed(String animalsBreed) {
        this.animalsBreed = animalsBreed;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getNurseryAddress() {
        return nurseryAddress;
    }

    public void setNurseryAddress(String nurseryAddress) {
        this.nurseryAddress = nurseryAddress;
    }

    public String getNursery() {
        return nursery;
    }

    public void setNursery(String nursery) {
        this.nursery = nursery;
    }

    public String getSkypeAccount() {
        return skypeAccount;
    }

    public void setSkypeAccount(String skypeAccount) {
        this.skypeAccount = skypeAccount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getOuthType() {
        return outhType;
    }

    public void setOuthType(String outhType) {
        this.outhType = outhType;
    }

    public String getOuthId() {
        return outhId;
    }

    public void setOuthId(String outhId) {
        this.outhId = outhId;
    }
}
