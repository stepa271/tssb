package com.tssb.models;

public class Train {
    private int trainNumber;
    private int capacity;

    public Train() {    }

    public Train(int trainNumber, int capacity) {
        this.trainNumber = trainNumber;
        this.capacity = capacity;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
