package com.AristoPets.entity;


import javax.persistence.*;

@Entity
@Table(name = "Cookies")
public class UserCookie {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "UUID")
    private String uuId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERS_ID")
    private User user;

    public UserCookie(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUUID() {
        return uuId;
    }

    public void setUUID(String UUID) {
        this.uuId = UUID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
