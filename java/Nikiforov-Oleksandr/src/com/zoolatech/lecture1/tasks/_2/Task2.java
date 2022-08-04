package com.zoolatech.lecture1.tasks._2;
import java.util.Scanner;

/**
 Write a program that accepts a distance in meters and time in seconds and outputs a speed
 in meters/second and kilometers/hour. The result should be a floating point number.
 */

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float distance = sc.nextFloat();
        float time = sc.nextFloat();
        calculateSpeed(distance,time);
    }


    public static void  calculateSpeed(float distance, float time){
        System.out.println("Distance in m/sec:" + distance / time);
        System.out.println("Distance in km/h: "+distance * 3.6f / time);
    }
}
