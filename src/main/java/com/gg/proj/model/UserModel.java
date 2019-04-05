package com.gg.proj.model;

import java.io.Serializable;

public class UserModel implements Serializable {
    private String firstName;
    private String lastName;
    private String mailAdress;

    public UserModel() {
    }

    public UserModel(String firstName, String lastName, String mailAdress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailAdress = mailAdress;
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

    public String getMailAdress() {
        return mailAdress;
    }

    public void setMailAdress(String mailAdress) {
        this.mailAdress = mailAdress;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mailAdress='" + mailAdress + '\'' +
                '}';
    }
}
