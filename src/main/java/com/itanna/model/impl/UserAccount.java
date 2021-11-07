package com.itanna.model.impl;


import com.itanna.model.IUserAccount;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity(name = "user_account")
public class UserAccount implements IUserAccount {

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "created_date")
    @CreationTimestamp
    private Instant createdDate;

    public Long getId() {
        return id;
    }

    public UserAccount(){}

    public UserAccount(String emailAddress, String firstName, String lastName, String password) {
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        createdDate = Instant.now();
    }

    @Override
    public Long getID() {
        return id;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public Instant getCreatedDate() {
        return createdDate;
    }
}
