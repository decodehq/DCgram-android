package com.example.decode.dcgram_android.presentation.models;

/**
 * Created by goran on 09.12.16..
 */
public class UserModel {

    private String userId;
    private String emailAddress;
    private String firstName;
    private String lastName;

    public UserModel(String userId, String emailAddress, String firstName, String lastName) {
        this.userId = userId;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
}
