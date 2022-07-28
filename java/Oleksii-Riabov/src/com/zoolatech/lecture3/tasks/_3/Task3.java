package com.zoolatech.lecture3.tasks._3;

import java.util.ArrayList;
import java.util.List;

/**
 * Create an hierarchy of 3 classes: Circle, Triangle, Rectangle, and a
 * basic interface Shape that provides methods to find a perimeter and
 * an area for each shape. In the main method, create a list of three
 * objects and display their perimeter and area. Then display the radius
 * of a circle and lengths of a triangle and rectangle sides for objects
 * stored in the list. Prevent other classes from extension from the Shape
 * interface. It should be also possible to check if two object references
 * of these types are the same and to print the inner state of an object
 * (like radius or width) to the console output when an object is passed
 * to the System.out.println method.
 */

public class Task3 {
    public static void main(String[] args) {
        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(new Circle(5));
        shapeList.add(new Circle(5));
        shapeList.add(new Triangle(3, 4, 5));
        shapeList.add(new Triangle(3, 4, 5));
        shapeList.add(new Rectangle(3, 5));
        shapeList.add(new Rectangle(3, 5));

        shapeList.stream().distinct().peek(Shape::findPerimeter).forEach(Shape::findArea);
        System.out.println();

        shapeList.stream().distinct().forEach(System.out::println);
    }
}
