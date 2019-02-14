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
        this.rideArrayList = new ArrayList<>(numRides);
        this.perRideTimelessBonus = perRideTimelessBonus;
        this.numSteps = numSteps;
    }

}
