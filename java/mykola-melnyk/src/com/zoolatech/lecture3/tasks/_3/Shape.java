package com.zoolatech.lecture3.tasks._3;

public sealed interface Shape
        permits Circle, Rectangle, Triangle {
     void findPerimeter();
     void findArea();

}
