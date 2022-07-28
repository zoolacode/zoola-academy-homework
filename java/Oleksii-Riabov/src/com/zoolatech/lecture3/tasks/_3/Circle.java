package com.zoolatech.lecture3.tasks._3;

import java.util.Objects;

public non-sealed class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void findPerimeter() {
        System.out.println("Perimeter of a Circle: " + Math.PI * 2 * radius);
    }

    @Override
    public void findArea() {
        System.out.println("Area of a Circle: " + Math.PI * (radius * radius));
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

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
