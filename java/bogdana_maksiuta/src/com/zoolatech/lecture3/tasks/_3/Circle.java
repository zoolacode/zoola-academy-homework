package com.zoolatech.lecture3.tasks._3;

import java.util.Objects;

public non-sealed class Circle implements Shape {
    final double PI = 3.1415926536;
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void findPerimeter() {
        int perimeter = (int) (radius * 2 * PI);
        System.out.println("The perimeter of the circle is " + perimeter);
    }

    @Override
    public void findArea() {
        int area = (int) (Math.pow(radius, 2) * PI);
        System.out.println("The area of the circle is " + area);
    }

    @Override
    public String toString() {
        return "Circle: " +
                "PI = " + PI +
                ", radius = " + radius + " ;";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.PI, PI) == 0 && radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(PI, radius);
    }
}

