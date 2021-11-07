package com.ebipay.model;

public class UserAccountDTO {
    private String firstName;
    private String lastName;
    private String password;
    private String emailAddress;

    public UserAccountDTO(String firstName, String lastName, String password, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
