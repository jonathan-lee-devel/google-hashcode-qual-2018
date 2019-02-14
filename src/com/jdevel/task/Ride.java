package com.jdevel.task;

public class Ride {

    private int id;

    private Intersection startIntersection;

    private Intersection finishIntersection;

    public Ride() {

    }

    public int distance() {
        return this.startIntersection.distance(this.finishIntersection);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Intersection getStartIntersection() {
        return startIntersection;
    }

    public void setStartIntersection(Intersection startIntersection) {
        this.startIntersection = startIntersection;
    }

    public Intersection getFinishIntersection() {
        return finishIntersection;
    }

    public void setFinishIntersection(Intersection finishIntersection) {
        this.finishIntersection = finishIntersection;
    }

}
