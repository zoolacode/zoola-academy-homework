package com.zoolatech.lecture3.tasks._3;

import java.util.ArrayList;

public interface Shape {

    double findPerimeter();

    double findArea();

    public static void main(String[] args) {
        double radius = 12;
        double rectangleLength = 10;
        double rectangleWidth = 15;
        double triangleSide = 8;
        ArrayList<Shape> shapesList = new ArrayList<>();
        Circle circle = new Circle(radius);
        Rectangle rectangle = new Rectangle(rectangleLength,rectangleWidth);
        Triangle triangle = new Triangle(triangleSide);
        shapesList.add(circle);
        shapesList.add(rectangle);
        shapesList.add(triangle);
        System.out.println("Perimeter of circle: " +shapesList.get(0).findPerimeter()+"\nArea of circle: "+shapesList.get(0).findArea());
        System.out.println("Perimeter of rectangle: " +shapesList.get(1).findPerimeter()+"\nArea of rectangle: "+shapesList.get(1).findArea());
        System.out.println("Perimeter of triangle: " +shapesList.get(2).findPerimeter()+"\nArea of triangle: "+shapesList.get(2).findArea());
        System.out.println("Circle radius: "+circle.getRadius());
        System.out.println("Rectangle width: "+rectangle.getWidth()+"\nRectangle length: "+rectangle.getLength());
        System.out.println("Triangle side: "+triangle.getSide());
    }


}
