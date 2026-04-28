package com.pdm.colors.models;

import java.io.Serializable;

public class ListElement implements Serializable {

    public String color;
    public String name;
    public String city;
    public String number;
    public String status;

    public ListElement(String color, String name, String city, String number, String status) {
        this.color = color;
        this.name = name;
        this.city = city;
        this.number = number;
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
