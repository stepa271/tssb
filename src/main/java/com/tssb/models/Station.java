package com.tssb.models;

public class Station {
    private  int id;
    public String name;

    public Station(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Station() {    }

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
