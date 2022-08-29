package com.zoolatech.lecture3.tasks._3;


import java.util.Objects;

public non-sealed class Circle implements Shape {
    private float radius;


    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public void area() {
        System.out.println("Area of circle=" + Math.PI * Math.pow(radius, 2));
    }

    @Override
    public void perimetr() {
        System.out.println("Perimert of circle=" + 2 * Math.PI * radius);
    }

    @Override
    public String toString() {
        return "Circle: " +
                "radius=" + radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Float.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
