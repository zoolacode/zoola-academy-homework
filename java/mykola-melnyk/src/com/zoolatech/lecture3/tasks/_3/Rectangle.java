package com.zoolatech.lecture3.tasks._3;

public final class Rectangle implements Shapes {
    double a;
    double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double calcPerimeter() {
        return 2 * (a + b);
    }

    public double calcArea() {
        return a * b;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Rectangle other = (Rectangle) obj;
        return a == other.a
                && b == other.b;
    }
}
