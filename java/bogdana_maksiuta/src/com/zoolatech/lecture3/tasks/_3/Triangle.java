package com.zoolatech.lecture3.tasks._3;

import java.util.Objects;

public non-sealed class Triangle implements Shape {
    int firstSide;
    int secondSide;
    int thirdSide;

    public Triangle(int firstSide, int secondSide, int thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    @Override
    public void findPerimeter() {
        int perimeters = firstSide + secondSide + thirdSide;
        System.out.println("The perimeter of the triangle is " + perimeters);
    }

    @Override
    public void findArea() {
        int p = (firstSide + secondSide + thirdSide) / 2;
        int area = (int) Math.sqrt(p * (p - firstSide) * (p - secondSide) * (p - thirdSide));
        System.out.println("The area of the triangle is " + area);
    }

    @Override
    public String toString() {
        return "Triangle: " +
                "firstSide = " + firstSide +
                ", secondSide = " + secondSide +
                ", thirdSide = " + thirdSide + " ;";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return firstSide == triangle.firstSide && secondSide == triangle.secondSide && thirdSide == triangle.thirdSide;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstSide, secondSide, thirdSide);
    }
}