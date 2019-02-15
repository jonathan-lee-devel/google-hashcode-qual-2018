package com.jdevel.task;

import java.util.ArrayList;

public class Vehicle {

    private int id;

    private ArrayList<Ride> rideArrayList;

    private Intersection currentLocation;

    private VehicleState currentState;

    private int currentRideIndex;

    public Vehicle(int id, Intersection currentLocation, VehicleState currentState) {
        this.setId(id);
        this.rideArrayList = new ArrayList<>();
        this.setCurrentLocation(currentLocation);
        this.setCurrentState(currentState);
    }

    public void assignRide(Ride ride) {
        this.rideArrayList.add(ride);
    }

    public void step(int simulationStep) {
        switch(this.getCurrentState()) {
            case AVAILABLE:
                this.setCurrentRideIndex(this.getCurrentRideIndex() + 1);// Update the ride index
                break;

            case WAITING:
                if (this.getCurrentRide().getEarliestStart() >= simulationStep) {// If it is at least the earliest start for the current ride
                    this.setCurrentState(VehicleState.EN_ROUTE);
                    this.stepTowardsIntersection(this.getCurrentRide().getFinishIntersection());
                }
                break;

            case EN_ROUTE:
                if (this.getCurrentLocation().equals(this.getCurrentRide().getFinishIntersection())) {// If it has reached the destination for the current ride
                    this.setCurrentState(VehicleState.AVAILABLE);
                }
                break;
        }
    }

    private void stepTowardsIntersection(Intersection toIntersection) {

    }

    public Ride getCurrentRide() {
        return this.getRideArrayList().get(this.getCurrentRideIndex());
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

    public Intersection getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Intersection currentLocation) {
        this.currentLocation = currentLocation;
    }

    public VehicleState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(VehicleState currentState) {
        this.currentState = currentState;
    }

    public int getCurrentRideIndex() {
        return currentRideIndex;
    }

    public void setCurrentRideIndex(int currentRideIndex) {
        this.currentRideIndex = currentRideIndex;
    }

    private enum VehicleState {
        AVAILABLE,
        EN_ROUTE,
        WAITING
    }
}
