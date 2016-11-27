package com.AristoPets.entity;


import javax.persistence.*;

@Entity
@Table(name = "Cookies")
public class Cookie {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "UUID")
    private String UUID;

    @OneToOne
    @JoinColumn(name = "USERS_ID")
    private long userId;

    
}
