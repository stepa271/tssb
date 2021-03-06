package com.tssb.models;


import org.springframework.stereotype.Component;

@Component
public class Schedule {
    private int id;
    private int trainNumber;
    private  int stationId;
    private String time;

    public Schedule(int id, int trainNumber, int stationId, String time) {
        this.id = id;
        this.trainNumber = trainNumber;
        this.stationId = stationId;
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

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
