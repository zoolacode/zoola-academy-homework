package com.zoolatech.lecture3.tasks._3;

import java.util.Objects;

public final class Triangle implements Shape {

    private int aLength;
    private int bLength;
    private int cLength;

    public Triangle(int aLength) {
        this(aLength, aLength, aLength);
    }

    public Triangle(int aLength, int bLength, int cLength) {
        if (checkTriangle(aLength, bLength, cLength)) {
            this.aLength = aLength;
            this.bLength = bLength;
            this.cLength = cLength;
        }else throw new IllegalArgumentException("Triangle does not exist");
    }

    @Override
    public double findPerimeter() {
        // P = a + b + c
        return aLength + bLength + cLength;
    }

    private boolean checkTriangle(int aLength, int bLength, int cLength) {
        // check if triangle was correctly built
        return aLength + bLength > cLength
                && aLength + cLength > bLength
                && bLength + cLength > aLength;
    }

    @Override
    public double findArea() {
        /*   ______________________
        S = √p(p - a)(p - b)(p - c)
        * */
        double p = findPerimeter() / 2;
        return Math.sqrt(p * ((p - aLength) * (p - bLength) * (p - cLength)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return aLength == triangle.aLength && bLength == triangle.bLength && cLength == triangle.cLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aLength, bLength, cLength);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "aLength=" + aLength +
                ", bLength=" + bLength +
                ", cLength=" + cLength +
                '}';
    }
}
