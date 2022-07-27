package com.zoolatech.lecture1.tasks._1;

import java.util.Scanner;

/**
 * Write a program that accepts numbers of miles as a floating point number,
 * converts it to kilometers and outputs the result.
 *         a. Input: 2.5
 *            Output: 4.0233603
 */
public class ConverterMiToKm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float miles = scanner.nextFloat();
        if (miles > 0) {
            converter(miles);
        } else {
            throw new IllegalArgumentException("Wrong number: " + miles);
        }
    }
    public static void converter (float miles) {
        final float METRIC_EQUIVALENT = 1.609344F;
        float kilometer = miles * METRIC_EQUIVALENT;
        System.out.println("From: " + miles + " mile \n" + "To: " + kilometer + " kilometer");
    }
}