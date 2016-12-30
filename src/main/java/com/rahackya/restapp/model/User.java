package com.rahackya.restapp.model;

import java.io.Serializable;

/**
 * Created by Rajmani on 12/29/16.
 */
public class User implements Serializable {
	private static final long serialVersionUID = -5984342856763220023L;
	private int id;
    private int rollno;
    private String name;
    private String email;
    private String phone;
    private String company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRollno() {
        return rollno;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
}
