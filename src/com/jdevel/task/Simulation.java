package com.jdevel.task;

import java.util.ArrayList;

public class Simulation {

    private Grid grid;

    private ArrayList<Vehicle> vehicleArrayList;

    private ArrayList<Ride> rideArrayList;

    private int perRideTimelessBonus;

    private int numSteps;

    public Simulation(int numRows, int numColumns, int numVehicles, int numRides, int perRideTimelessBonus, int numSteps) {
        this.grid = new Grid(numRows, numColumns);
        this.vehicleArrayList = new ArrayList<>(numVehicles);
        for (int i = 0; i < numVehicles; i++) {
            this.vehicleArrayList.add(new Vehicle(i));
        }
        this.rideArrayList = new ArrayList<>(numRides);
        this.perRideTimelessBonus = perRideTimelessBonus;
        this.numSteps = numSteps;
    }

    public void addRide(Ride ride) {
        this.rideArrayList.add(ride);
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public ArrayList<Vehicle> getVehicleArrayList() {
        return vehicleArrayList;
    }

    public void setVehicleArrayList(ArrayList<Vehicle> vehicleArrayList) {
        this.vehicleArrayList = vehicleArrayList;
    }

    public ArrayList<Ride> getRideArrayList() {
        return rideArrayList;
    }

    public void setRideArrayList(ArrayList<Ride> rideArrayList) {
        this.rideArrayList = rideArrayList;
    }

    public int getPerRideTimelessBonus() {
        return perRideTimelessBonus;
    }

    public void setPerRideTimelessBonus(int perRideTimelessBonus) {
        this.perRideTimelessBonus = perRideTimelessBonus;
    }

    public int getNumSteps() {
        return numSteps;
    }

    public void setNumSteps(int numSteps) {
        this.numSteps = numSteps;
    }
}
