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
        for (char c : charArray) {
            switch (c) {
                case '1' -> {
                    result.append(c).append("(one)");
                }
                case '2' -> {
                    result.append(c).append("(two)");
                }
                case '3' -> {
                    result.append(c).append("(three)");
                }
                case '4' -> {
                    result.append(c).append("(four)");
                }
                case '5' -> {
                    result.append(c).append("(five)");
                }
                case '6' -> {
                    result.append(c).append("(six)");
                }
                case '7' -> {
                    result.append(c).append("(seven)");
                }
                case '8' -> {
                    result.append(c).append("(eight)");
                }
                case '9' -> {
                    result.append(c).append("(nine)");
                }
                case '0' -> {
                    result.append(c).append("(zero)");
                }
                default -> {
                    System.out.println("Input error!");
                    return;
                }
            }
        }
        System.out.println(result);
    }
}
