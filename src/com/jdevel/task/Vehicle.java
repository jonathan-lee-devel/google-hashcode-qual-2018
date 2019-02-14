package com.jdevel.task;

import java.util.ArrayList;

public class Vehicle {

    private int id;

    private ArrayList<Ride> rideArrayList;

    public Vehicle() {
        this.rideArrayList = new ArrayList<>();
    }

    public void assignRide(Ride ride) {
        this.rideArrayList.add(ride);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
