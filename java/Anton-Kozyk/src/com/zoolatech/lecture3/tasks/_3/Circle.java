package com.zoolatech.lecture3.tasks._3;

import java.util.Objects;

public non-sealed class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double findPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double findArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void printArea() {
        System.out.println("Circle area: " + findArea());
    }

    @Override
    public void printPerimeter() {
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
