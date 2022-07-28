package com.zoolatech.lecture3.tasks._3;

import java.util.Objects;

public non-sealed class Circle implements Shape {
    final static double PI = 3.1415926536;
    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public void findPerimeter() {
        float perimeter = (float) (radius * 2 * PI);
        System.out.println("The perimeter of the circle is " + perimeter);
    }

    @Override
    public void findArea() {
        float area = (float) (Math.pow(radius, 2) * PI);
        System.out.println("The area of the circle is " + area);
    }

    @Override
    public String toString() {
        return "Circle: " +
                "radius = " + radius + " ;";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}

