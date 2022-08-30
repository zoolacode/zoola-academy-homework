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
        char[] chars = string.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char character : chars) {
            builder.append(character);
            switch (character) {
                case '1' -> builder.append("(one)");
                case '2' -> builder.append("(two)");
                case '3' -> builder.append("(three)");
                case '4' -> builder.append("(four)");
                case '5' -> builder.append("(five)");
                case '6' -> builder.append("(six)");
                case '7' -> builder.append("(seven)");
                case '8' -> builder.append("(eight)");
                case '9' -> builder.append("(nine)");
                case '0' -> builder.append("(zero)");
            }
        }
        return builder.toString();
    }
}
