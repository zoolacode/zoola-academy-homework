package com.zoolatech.lecture3.tasks._3;

import java.util.Objects;

import static java.lang.Math.PI;

public final class Circle implements Shape {

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double findPerimeter() {
        //P = 2 * П * r
        return radius * PI * 2;
    }

    @Override
    public double findArea() {
        //S = П * r^2
        return Math.pow(radius, 2) * PI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius;
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
