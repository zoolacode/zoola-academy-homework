package com.zoolatech.lecture3.tasks._3;

import java.util.Objects;

public non-sealed class Rectangle implements Shape {
    private float a, b;

    public Rectangle(float a, float b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void area() {
        System.out.println("Aread of rectangle=" + a * b);
    }

    @Override
    public void perimetr() {
        System.out.println("Perimetr of rectangle=" + (2 * a + 2 * b));
    }

    @Override
    public String toString() {
        return "Rectangle: " +
                "a=" + a +
                ", b=" + b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Float.compare(rectangle.a, a) == 0 && Float.compare(rectangle.b, b) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
