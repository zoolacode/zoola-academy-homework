package com.zoolatech.lecture3.tasks._3;

public class Triangle implements Shape {

    double side;
    public Triangle(double side){
        this.side = side;

    }

    @Override
    public double findPerimeter() {
        double perimeter = side*3;
        return perimeter;
    }

    public double getSide() {
        return side;
    }

    //(a*sqrt(3))/4 - same sides triangle square
    @Override
    public double findArea(){
        double area = (Math.pow(side, 2)*Math.sqrt(3))/4;
        return area;
    }
}
