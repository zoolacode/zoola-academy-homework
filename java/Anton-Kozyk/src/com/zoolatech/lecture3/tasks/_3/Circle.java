package com.zoolatech.lecture3.tasks._3;

import java.util.Objects;

public non-sealed class Circle extends Figure implements Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double findPerimeter() {
        double circlePerimeter = 2 * Math.PI * radius;
        return circlePerimeter;
    }

    @Override
    public double findArea() {
        double circleArea = Math.PI * Math.pow(radius, 2);
        return circleArea;
    }

    @Override
    void printArea() {
        System.out.println("Circle area: " + findArea());
    }

    @Override
    void printPerimeter() {
        System.out.println("Circle perimeter: " + findPerimeter());
    }

    @Override
    public String toString() {
        return "Circle {" +
                "radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
