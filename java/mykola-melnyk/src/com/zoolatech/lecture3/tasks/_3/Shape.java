package com.zoolatech.lecture3.tasks._3;

public sealed interface Shape
        permits Circle {
     double calcPerimeter();
     double calcArea();
     default void printPerimeter() {
          System.out.println(this.calcPerimeter());
     }
     default void printArea() {
          System.out.println(this.calcArea());
     };

}
