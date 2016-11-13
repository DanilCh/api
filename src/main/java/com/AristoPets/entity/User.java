package com.AristoPets.entity;

public class User {

    private long id;
    private AuthType authType; // String type is temporary
    private String authId; // String type is temporary
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String skypeAccount;
    private String nursery;
    private String nurseryAddress;
    private String club;
    private String contractOfSale;
    private String animalsBreed; // String type is temporary

    public User() {
    }

    public String getAnimalsBreed() {
        return animalsBreed;
    }

    public void setAnimalsBreed(String animalsBreed) {
        this.animalsBreed = animalsBreed;
    }

    public String getContractOfSale() {
        return contractOfSale;
    }

    public void setContractOfSale(String contractOfSale) {
        this.contractOfSale = contractOfSale;
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

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) { this.authId = authId; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", authType='" + authType + '\'' +
                ", authId='" + authId + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", skypeAccount='" + skypeAccount + '\'' +
                ", nursery='" + nursery + '\'' +
                ", nurseryAddress='" + nurseryAddress + '\'' +
                ", club='" + club + '\'' +
                ", conractOfSale='" + contractOfSale + '\'' +
                ", animalsBreed='" + animalsBreed + '\'' +
                '}';
    }
}
