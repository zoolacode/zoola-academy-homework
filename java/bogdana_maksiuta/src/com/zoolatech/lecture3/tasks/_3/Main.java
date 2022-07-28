package com.zoolatech.lecture3.tasks._3;

import java.util.ArrayList;

/**
 * Create an hierarchy of 3 classes:
 * Circle, Triangle, Rectangle,
 * and a basic interface Shape that provides methods to find a perimeter and an area for each shape.
 * In the main method, create a list of three objects and display their perimeter and area.
 * Then display the radius of a circle and lengths of a triangle and rectangle sides for objects stored in the list.
 * Prevent other classes from extension from the Shape interface.
 * It should be also possible to check if two object references of these types are the same and
 * to print the inner state of an object (like radius or width) to the console output when
 * an object is passed to the System.out.println method.
 */
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(3, 5);
        Triangle triangle = new Triangle(3, 4, 5);
        Triangle triangle2 = new Triangle(3, 4, 6);

        ArrayList<Shape> listOfShapes = new ArrayList<>();
        listOfShapes.add(triangle);
        listOfShapes.add(circle);
        listOfShapes.add(rectangle);

        for (Shape shape : listOfShapes) {
            shape.findArea();
            shape.findPerimeter();
        }

        for (Shape shape : listOfShapes) {
            System.out.println(shape);
        }

        listOfShapes.add(triangle2);
        System.out.println("\nAre those triangles are equals? - " + triangle.equals(triangle2));
    }
}
