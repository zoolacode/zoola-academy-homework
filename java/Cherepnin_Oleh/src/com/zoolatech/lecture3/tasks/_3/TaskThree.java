package com.zoolatech.lecture3.tasks._3;

import java.util.List;

/**
 * Create an hierarchy of 3 classes: Circle, Triangle, Rectangle, and a basic interface Shape that provides methods
 * to find a perimeter and an area for each shape. In the main method, create a list of three objects and display
 * their perimeter and area. Then display the radius of a circle and lengths of a triangle and rectangle sides for
 * objects stored in the list. Prevent other classes from extension from the Shape interface. It should be also possible
 * to check if two object references of these types are the same and to print the inner state of an object
 * (like radius or width) to the console output when an object is passed to the System.out.println method.
 */
public class TaskThree {
    public static void main(String[] args) {
        List<Shape> shapes = List.of(
                new Circle(5),
                new Rectangle(5),
                new Triangle(3, 4, 5));
        shapes.forEach(s -> System.out.println(s
                + "\n has perimeter: " + s.findPerimeter()
                + "\n and area: " + s.findArea()));
        try {
            //check incorrect triangle
            Shape shape = new Triangle(1, 3, 5);
            shape.findArea();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
}

