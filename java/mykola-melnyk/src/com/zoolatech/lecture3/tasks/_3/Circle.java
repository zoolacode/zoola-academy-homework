package com.zoolatech.lecture3.tasks._3;

public final class Circle implements Shapes {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calcPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle{radius=%s}".formatted(radius);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Circle other = (Circle) obj;
        return radius == other.radius;
    }
}
