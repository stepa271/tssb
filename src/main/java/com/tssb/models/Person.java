package com.tssb.models;

public class Person {
    private int id;
    private String name;
    private String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
    public Person() {}

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Person(String name, String surname, String email){
        this.name=name;
        this.surname=surname;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
