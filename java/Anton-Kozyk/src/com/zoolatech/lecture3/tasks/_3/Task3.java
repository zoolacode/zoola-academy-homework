package com.zoolatech.lecture3.tasks._3;

import java.util.ArrayList;

/**
 * Create a hierarchy of 3 classes: Circle, Triangle, Rectangle, and
 * a basic interface Shape that provides methods to find a perimeter
 * and an area for each shape. In the main method, create a list of
 * three objects and display their perimeter and area. Then display
 * the radius of a circle and lengths of a triangle and rectangle
 * sides for objects stored in the list. Prevent other classes from
 * extension from the Shape interface. It should be also possible
 * to check if two object references of these types are the same and
 * to print the inner state of an object (like radius or width) to
 * the console output when an object is passed to the System.out.println method.
 */

public class Task3 {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        Triangle triangle1 = new Triangle(5, 6, 4);
        Rectangle rectangle1 = new Rectangle(6, 6);
        Rectangle rectangle2 = new Rectangle(3, 3);

        ArrayList<Shape> figures = new ArrayList<>();
        figures.add(circle1);
        figures.add(triangle1);
        figures.add(rectangle1);
        figures.add(rectangle2);

        for (Shape fig : figures) {
            System.out.println(fig);
            fig.printArea();
            fig.printPerimeter();
            System.out.println();
        }
    }
}
