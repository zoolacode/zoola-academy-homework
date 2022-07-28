package com.zoolatech.lecture4.tasks._7;

import java.util.Scanner;

/**
 * Create a method that accepts a string of digits and after each digit appends its string representation in parentheses
 * Input: “12345”
 * Output: “1(one)2(two)3(three)4(four)5(five)”
 */
public class TaskSeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input numbers:");
        System.out.println(convert(scanner.next()));
    }

    private static String convert(String string) {
        String[] strs = string.split("");
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            switch (str) {
                case "1" -> builder.append(str).append("(one)");
                case "2" -> builder.append(str).append("(two)");
                case "3" -> builder.append(str).append("(three)");
                case "4" -> builder.append(str).append("(four)");
                case "5" -> builder.append(str).append("(five)");
                case "6" -> builder.append(str).append("(six)");
                case "7" -> builder.append(str).append("(seven)");
                case "8" -> builder.append(str).append("(eight)");
                case "9" -> builder.append(str).append("(nine)");
                case "0" -> builder.append(str).append("(zero)");
            }
        }
        return builder.toString();
    }
}
