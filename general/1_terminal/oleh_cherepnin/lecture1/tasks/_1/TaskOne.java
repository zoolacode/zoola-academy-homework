package com.zoolatech.lecture1.tasks._1;

/**
 * Write a program that accepts numbers of miles as a floating point number,
 * converts it to kilometers and outputs the result.
 */
public class TaskOne {

    public static void main(String[] args) {
        System.out.println(convertToKm(2.5f));
    }

    public static double convertToKm(float miles) {
        return miles * 1.609344;
    }
}
