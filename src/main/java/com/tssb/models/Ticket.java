package com.tssb.models;

public class Ticket {
    private int id;
    private int trainNumber;
    private int clientId;

    public Ticket(int id, int trainNumber, int clientId) {
        this.id = id;
        this.trainNumber = trainNumber;
        this.clientId = clientId;
    }

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
