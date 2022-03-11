package com.tssb.models;

public class Schedule {
    private int id;
    private int trainNumber;
    private int idStation;
    private String time;

    public Schedule(int id, int trainNumber, int idStation, String time) {
        this.id = id;
        this.trainNumber = trainNumber;
        this.idStation = idStation;
        this.time = time;
    }

    public Schedule() {}

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

    public int getIdStation() {
        return idStation;
    }

    public void setIdStation(int idStation) {
        this.idStation = idStation;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
