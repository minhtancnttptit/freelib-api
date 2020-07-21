package com.newptit.freelib.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_")
public class User {
    @Id
    private String id;
    private String name;
    private String gender;
    private String email;
    private String dob;
    private String address;

    public User() {
    }

    public User(String id, String name, String gender, String email, String dob, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
