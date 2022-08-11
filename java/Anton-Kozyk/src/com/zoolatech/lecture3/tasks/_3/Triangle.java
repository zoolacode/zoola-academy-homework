package com.zoolatech.lecture3.tasks._3;

import java.util.Objects;

public non-sealed class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double findPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double findArea() {
        double semiPerimeter = findPerimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - sideA) *
                (semiPerimeter - sideB) * (semiPerimeter - sideC));
    }

    @Override
    public void printArea() {
        System.out.println("Triangle area: " + findArea());
    }

    @Override
    public void printPerimeter() {
        System.out.println("Triangle perimeter: " + findPerimeter());
    }

    @Override
    public String toString() {
        return "Triangle {" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.sideA, sideA) == 0 &&
                Double.compare(triangle.sideB, sideB) == 0 &&
                Double.compare(triangle.sideC, sideC) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB, sideC);
    }
}
