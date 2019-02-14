package com.jdevel.task;

import java.util.ArrayList;

public class Vehicle {

    private int id;

    private ArrayList<Ride> rideArrayList;

    public Vehicle(int id) {
        this.setId(id);
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

    public ArrayList<Ride> getRideArrayList() {
        return rideArrayList;
    }

    public void setRideArrayList(ArrayList<Ride> rideArrayList) {
        this.rideArrayList = rideArrayList;
    }
}
