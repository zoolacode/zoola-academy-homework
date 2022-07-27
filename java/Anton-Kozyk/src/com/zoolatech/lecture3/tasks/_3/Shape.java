package com.zoolatech.lecture3.tasks._3;

public sealed interface Shape permits Circle, Triangle, Rectangle {
    double findPerimeter();

    double findArea();
}
