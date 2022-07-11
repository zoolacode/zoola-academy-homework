package com.zoolatech.lecture1.tasks._2;

/**
 * Write a program that accepts a distance in meters and time in seconds
 * and outputs a speed in meters/second and kilometers/hour.
 * The result should be a floating point number.
 * Input: 80
 * 10
 * Output:8.0
 * 28.8
 * Explanation: the first input number is a distance, second - time;
 * the first output number is a speed in m/s, second - speed in km/h
 */
public class TaskTwo {

    public static void main(String[] args) {
        float metersInSecond = countMetersInSecond(80, 10);
        float kmInHour = countKmInHour(metersInSecond);
        System.out.println(metersInSecond + "\n" + kmInHour);
    }

    public static float countMetersInSecond(int distance, int time) {
        return distance / (float) time;
    }

    public static float countKmInHour(float speed) {
        return (float) (speed * 3.6);  //3.6 = sec * min
    }
}
