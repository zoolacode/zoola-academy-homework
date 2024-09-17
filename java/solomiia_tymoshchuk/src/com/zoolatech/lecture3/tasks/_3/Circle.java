package com.zoolatech.lecture3.tasks._3;

public class Circle implements Shape{

    double radius;
    public Circle(double radius){
        this.radius = radius;
    }
    final double pi = 3.14;
    double number = 2;

    public double getRadius() {
        return radius;
    }

    //2piR
    @Override
    public double findPerimeter() {
       double perimeter = number*pi*radius;
       return perimeter;
    }

    //2pr^2
    @Override
    public double findArea(){
       double area = pi*number*Math.pow(radius,2);
       return area;
    }
}
