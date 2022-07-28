package com.zoolatech.lecture3.tasks._3;

import java.util.Objects;

public non-sealed class Rectangle implements Shape {
    private final double width;
    private final double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    @Override
    public void findPerimeter() {
        System.out.println("Perimeter of a Rectangle: " + (width + length) * 2);
    }

    @Override
    public void findArea() {
        System.out.println("Area of a Rectangle: " + width * length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.width, width) == 0 && Double.compare(rectangle.length, length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, length);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }
}
