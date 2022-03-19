package com.tssb.models;

import org.hibernate.validator.constraints.NotEmpty;

public class Train {

    @NotEmpty(message = "Name should not be empty")
    private int id;
    private int capacity;

    public Train() {    }

    public Train(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int trainNumber) {
        this.id = trainNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
