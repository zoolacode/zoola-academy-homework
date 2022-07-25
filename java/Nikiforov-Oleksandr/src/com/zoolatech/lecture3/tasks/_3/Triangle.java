package com.zoolatech.lecture3.tasks._3;

import java.util.Objects;

public non-sealed class Triangle implements Shape {
    private float a, b, c;

    public Triangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void area() {
        float p = (a + b + c) / 2;
        System.out.println("Aread of triangle=" + Math.sqrt(p * (p - a) * (p - b) * (p - c)));
    }

    @Override
    public void perimetr() {
        System.out.println("Perimetr of triangle=" + (a + b + c));
    }

    @Override
    public String toString() {
        return "Triangle: " +
                "a=" + a +
                ", b=" + b +
                ", c=" + c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Float.compare(triangle.a, a) == 0 && Float.compare(triangle.b, b) == 0 && Float.compare(triangle.c, c) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}
