package com.zoolatech.lecture1.tasks._1;

import java.util.Scanner;

/**
 * Write a program that accepts numbers of miles as a floating point number,
 * converts it to kilometers and outputs the result.
 */
public class TaskOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number of miles:");
        System.out.println(convertToKm(scanner.nextFloat()));    }

    public static double convertToKm(float miles) {
        return miles * 1.609344;
    }
}
