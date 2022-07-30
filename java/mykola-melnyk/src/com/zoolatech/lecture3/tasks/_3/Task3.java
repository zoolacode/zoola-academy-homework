package com.zoolatech.lecture3.tasks._3;

import java.util.ArrayList;

/** Create a hierarchy of 3 classes: Circle, Triangle, Rectangle,
 * and a basic interface Shape that provides methods to find a
 * perimeter and an area for each shape.
 * In the main method, create a list of three objects and display
 * their perimeter and area. Then display the radius of a circle and lengths
 * of a triangle and rectangle sides for objects stored in the list.
 * Prevent other classes from extension from the Shape interface.
 * It should be also possible to check if two object references of these
 * types are the same and to print the inner state of an object
 * (like radius or width) to the console output when an object
 * is passed to the System.out.println method.
 */

public class Task3 {
    public static void main(String[] args) {

        var circle = new Circle(10);

        var triangle = new Triangle(4, 13, 15);

        var rectangle = new Rectangle(2,4);

        ArrayList<Shape> shape = new ArrayList<>();
        shape.add(circle);
        shape.add(triangle);
        shape.add(rectangle);
        for (Shape e : shape) {
            e.findArea();
            e.findPerimeter();
        }

        for (Shape e : shape) {
            System.out.println(e);
        }

        var circle2 = new Circle(11);
        System.out.println(circle.equals(circle2));
        var circle3 = new Circle(10);
        System.out.println(circle.equals(circle3));
    }
}
