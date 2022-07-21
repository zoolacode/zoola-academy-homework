package com.zoolatech.lecture3.tasks._3;

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
        Triangle triangle2 = new Triangle(3, 4, 5);
        Triangle triangle3 = new Triangle(3, 4, 6);

        circle.findArea();
        circle.findPerimeter();
        rectangle.findArea();
        rectangle.findPerimeter();
        triangle.findArea();
        triangle.findPerimeter();

        System.out.println("\nThe radius of a circle is: " + circle.radius);
        System.out.println("The lengths of a triangle are: " + triangle.firstSide + ", " + triangle.secondSide +
                ", " + triangle.thirdSide + " ;");
        System.out.println("The lengths of a rectangle are: " + rectangle.firstSide + ", " + rectangle.secondSide + " ;");

        System.out.println("\nAre those triangles are equals? - " + triangle.equals(triangle2));
        System.out.println("Are those triangles are equals? - " + triangle.equals(triangle3));

        System.out.println("\n" + circle);
        System.out.println(rectangle);
        System.out.println(triangle);
        System.out.println(triangle3);
    }
}
