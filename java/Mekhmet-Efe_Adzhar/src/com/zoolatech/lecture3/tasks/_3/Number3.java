package com.zoolatech.lecture3.tasks._3;

/*
Create a hierarchy of 3 classes:
Circle, Triangle, Rectangle, and a basic interface
Shape that provides methods to find a perimeter and an area for each shape.
In the main method, create a list of three objects and display their perimeter and area.
Then display the radius of a circle and lengths of a triangle and rectangle sides for objects stored in the list.
Prevent other classes from extension from the Shape interface.
It should be also possible to check if two object references of these types
are the same and to print the inner state of an object (like radius or width)
to the console output when an object is passed to the System.out.println method.
*/

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Number3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Shape> shapes = new ArrayList<>();

        System.out.println("Input Circles Radius");
        Circle circle = new Circle(scanner.nextDouble());
        shapes.add(0, circle);
        System.out.println("Circle radius is: " + circle.getRadius() + "\n");

        System.out.println("Input Triangle 3 sides in a row:");
        Triangle triangle = new Triangle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
        shapes.add(1, triangle);
        System.out.println("Triangle sides are: " + triangle + "\n");

        System.out.println("Input Width and Length of a Rectangle:");
        Rectangle rectangle = new Rectangle(scanner.nextDouble(), scanner.nextDouble());
        shapes.add(2, rectangle);
        System.out.println("Rectangle: " + rectangle + "\n");

        System.out.println("List have this Shapes:");
        for (Shape shape : shapes) {
            String string = shape.toString();
            System.out.println(string);
        }
        System.out.println();
            System.out.println("Circle Perimeter: " + circle.getPerimeter() + "\n" + "Circle Area: " + circle.getArea());
            System.out.println("Triangle Perimeter: " + triangle.getPerimeter() + "\n" + "Triangle Area: " + triangle.getArea());
            System.out.println("Rectangle Perimeter: " + rectangle.getPerimeter() + "\n" + "Rectangle Area: " + rectangle.getArea() + "\n");

        for (Shape shape : shapes) {
            System.out.println("Checking if two object references of these types are the same ");
            System.out.println("Input a radius of a new Circle");
            shape = new Circle(scanner.nextDouble());
            System.out.println("Two object references states are :" + " " + shape.equals(circle));
            System.out.println("Second object references states is " + shape);
            System.out.println("Input a sides of a new Triangle");
            shape = new Triangle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
            System.out.println("Two object references states are :" + " " + shape.equals(triangle));
            System.out.println("Second object references states is " + shape);
            System.out.println("Input a sides of a new Rectangle");
            shape = new Rectangle(scanner.nextDouble(), scanner.nextDouble());
            System.out.println("Two object references states are :" + " " + shape.equals(rectangle));
            System.out.println("Second object references states is " + shape);
            break;
        }
    }
}

sealed interface Shape permits Circle, Triangle, Rectangle {
    double getArea();
    double getPerimeter();
}

final class Circle implements Shape {

    private static final double PI = 3.14159;
    private final double radius;

    public Circle(double r) {
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public String toString() {
        return "Circle : radius = " + radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(PI, radius);
    }
}

final class Triangle implements Shape {
    private final double side1;
    private final double side2;
    private final double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        return (side1 + side2 + side3) / 2;
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle: Side 1 = " + side1 + ", Side 2 = " + side2
                + ", Side 3 = " + side3 + ", Perimeter: " + getPerimeter();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.side1, side1) == 0
                && Double.compare(triangle.side2, side2) == 0
                && Double.compare(triangle.side3, side3) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side1, side2, side3);
    }
}

final class Rectangle implements Shape {
    private final double width;
    private final double length;

    public Rectangle(double lenght, double width) {
        this.length = lenght;
        this.width = width;
    }

    @Override
    public double getArea() {
        return (length * width);
    }

    @Override
    public double getPerimeter() {
        return (2 * (length + width));
    }

    @Override
    public String toString() {
        return "Rectangle:width= " + width + ", length=" + length;
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
}