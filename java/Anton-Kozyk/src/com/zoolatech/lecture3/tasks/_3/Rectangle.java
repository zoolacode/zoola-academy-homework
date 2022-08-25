package com.zoolatech.lecture3.tasks._3;

import java.util.Objects;

public non-sealed class Rectangle implements Shape {
    private double weight;
    private double height;

    public Rectangle(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public double findPerimeter() {
        return 2 * (weight * height);
    }

    @Override
    public double findArea() {
        return weight * height;
    }

    @Override
    public void printArea() {
        System.out.println("Rectangle area: " + findArea());
    }

    @Override
    public void printPerimeter() {
        System.out.println("Rectangle perimeter: " + findPerimeter());
    }

    @Override
    public String toString() {
        return "Rectangle {" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.weight, weight) == 0 &&
                Double.compare(rectangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, height);
    }
}
