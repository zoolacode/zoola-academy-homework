package com.zoolatech.lecture4.tasks._7;

import java.util.Scanner;

/**
 * Create a method that accepts a string of digits and after each digit appends
 * its string representation in parentheses.
 */

public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.next();
        outputDigits(digits);
    }

    public static void outputDigits(String digits) {
        char[] charArray = digits.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char digitNumber : charArray) {
            result.append(digitNumber);
            String stringNumber;
            switch (digitNumber) {
                case '1' -> {
                    stringNumber = "(one)";
                }
                case '2' -> {
                    stringNumber = "(two)";
                }
                case '3' -> {
                    stringNumber = "(three)";
                }
                case '4' -> {
                    stringNumber = "(four)";
                }
                case '5' -> {
                    stringNumber = "(five)";
                }
                case '6' -> {
                    stringNumber = "(six)";
                }
                case '7' -> {
                    stringNumber = "(seven)";
                }
                case '8' -> {
                    stringNumber = "(eight)";
                }
                case '9' -> {
                    stringNumber = "(nine)";
                }
                case '0' -> {
                    stringNumber = "(zero)";
                }
                default -> {
                    System.out.println("Input error!");
                    return;
                }
            }
            result.append(stringNumber);
        }
        System.out.println(result);
    }
}
