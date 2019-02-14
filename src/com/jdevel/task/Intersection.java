package com.jdevel.task;

import java.awt.Point;

public class Intersection extends Point {

    public static int calculateDistance(Point point1, Point point2) {
        return (Math.abs(point1.x - point2.x) + Math.abs(point1.y - point2.y));
    }

    public Intersection(int x, int y) {
        this.setLocation(x, y);
    }

    public Intersection() {}

    public int distance(Point toPoint) {
        return Intersection.calculateDistance(this, toPoint);
    }

}
