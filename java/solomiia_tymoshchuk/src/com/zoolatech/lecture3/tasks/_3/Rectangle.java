package com.zoolatech.lecture3.tasks._3;

public class Rectangle implements Shape {
    double length;
    double width;
    double number = 2;

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }


    @Override
    public double findPerimeter() {
        return number*(length+width);
    }

    @Override
    public double findArea() {
        return width*length;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}
