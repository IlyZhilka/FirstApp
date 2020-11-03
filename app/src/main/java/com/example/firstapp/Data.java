package com.example.firstapp;

public class Data {

    private String name;

    private String surname;

    public Data(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Data() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}