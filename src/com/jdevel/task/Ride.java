package com.jdevel.task;

public class Ride {

    private int id;

    private Intersection startIntersection;

    private Intersection finishIntersection;

    private int earliestStart;

    private int latestFinish;

    public Ride(int rideId, Intersection startIntersection, Intersection finishIntersection, int earliestStart, int latestFinish) {
        this.setId(rideId);
        this.setStartIntersection(startIntersection);
        this.setFinishIntersection(finishIntersection);
        this.setEarliestStart(earliestStart);
        this.setLatestFinish(latestFinish);

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

    public int getEarliestStart() {
        return earliestStart;
    }

    public void setEarliestStart(int earliestStart) {
        this.earliestStart = earliestStart;
    }

    public int getLatestFinish() {
        return latestFinish;
    }

    public void setLatestFinish(int latestFinish) {
        this.latestFinish = latestFinish;
    }
}
