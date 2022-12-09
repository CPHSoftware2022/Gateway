package com.exam.Gateway.test_model;

import javax.persistence.Column;

public class Address {

    private Long id;
    private String street;
    private String city;
    private int postalCode;

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public int getPostalCode() {
        return postalCode;
    }
}
