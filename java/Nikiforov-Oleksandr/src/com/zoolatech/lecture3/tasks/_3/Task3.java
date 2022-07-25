package com.zoolatech.lecture3.tasks._3;

import java.util.ArrayList;

/**
 * Create an hierarchy of 3 classes: Circle, Triangle, Rectangle, and a basic interface Shape
 * that provides methods to find a perimeter and an area for each shape. In the main method,
 * create a list of three objects and display their perimeter and area. Then display the radius of a circle and
 * lengths of a triangle and rectangle sides for objects stored in the list. Prevent other classes from extension
 * from the Shape interface. It should be also possible to check if two object references of these types are the same
 * and to print the inner state of an object (like radius or width) to the console output when an object is passed
 * to the System.out.println method.
 */
public class Task3 {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(5, 5, 5);
        Rectangle rectangle = new Rectangle(4, 5);

        ArrayList<Shape> shapeList = new ArrayList<>();
        shapeList.add(circle);
        shapeList.add(triangle);
        shapeList.add(rectangle);

        for (Shape shape : shapeList) {
            shape.area();
            shape.perimetr();
            System.out.println();
        }
        System.out.println();
        for (Shape shape : shapeList) {
            System.out.println(shape);
        }
        System.out.println();
        Circle circle1 = new Circle(5);
        System.out.println("Are objects the same? " + circle.equals(circle1));
    }
}
