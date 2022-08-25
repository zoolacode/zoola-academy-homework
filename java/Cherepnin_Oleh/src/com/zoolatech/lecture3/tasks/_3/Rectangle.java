package com.zoolatech.lecture3.tasks._3;

import java.util.Objects;

public final class Rectangle implements Shape {

    private int height;
    private int width;

    public Rectangle(int width) {
        this(width, width);
    }

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double findPerimeter() {
        // P = x * 2 + y * 2
        return width * 2 + height * 2;
    }

    @Override
    public double findArea() {
        // S = x * y
        return width * height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return height == rectangle.height && width == rectangle.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
