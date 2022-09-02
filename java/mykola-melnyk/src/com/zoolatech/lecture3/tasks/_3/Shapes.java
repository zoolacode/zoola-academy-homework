package com.zoolatech.lecture3.tasks._3;

public sealed interface Shapes
        permits Circle, Rectangle, Triangle {
     double calcPerimeter();
     double calcArea();
     default void printPerimeter() {
          System.out.println(this.calcPerimeter());
     }
     default void printArea() {
          System.out.println(this.calcArea());
     };

}
