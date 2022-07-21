package com.zoolatech.lecture3.tasks._3;

import java.util.Objects;

public non-sealed class Rectangle implements Shape {
    int firstSide;
    int secondSide;

    public Rectangle(int firstSide, int secondSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
    }

    @Override
    public void findPerimeter() {
        int perimeter = 2 * (firstSide + secondSide);
        System.out.println("The perimeter of the rectangle is " + perimeter);
    }

    @Override
    public void findArea() {
        int area = firstSide * secondSide;
        System.out.println("The area of the rectangle is " + area);
    }

    @Override
    public String toString() {
        return "Rectangle: " +
                "firstSide = " + firstSide +
                ", secondSIde = " + secondSide + " ;";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return firstSide == rectangle.firstSide && secondSide == rectangle.secondSide;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstSide, secondSide);
    }
}
