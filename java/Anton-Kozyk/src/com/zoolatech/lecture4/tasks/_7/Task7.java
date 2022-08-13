package com.zoolatech.lecture4.tasks._7;

/**
 * Create a method that accepts a string of digits and after each
 * digit appends its string representation in parentheses
 * <p>
 * Input: “12345”
 * Output: “1(one)2(two)3(three)4(four)5(five)”
 */

public class Task7 {
    public static void main(String[] args) {
        System.out.println(digitToString("12345"));
        System.out.println(digitToString("56789"));
    }

    static String digitToString(String str) {
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            result.append(switch (ch) {
                case '1' -> "1(one)";
                case '2' -> "2(two)";
                case '3' -> "3(three)";
                case '4' -> "4(four)";
                case '5' -> "5(five)";
                case '6' -> "6(six)";
                case '7' -> "7(sever)";
                case '8' -> "8(eight)";
                case '9' -> "9(nine)";
                case '0' -> "0(zero)";
                default -> throw new IllegalStateException("Unexpected value: " + ch);
            });
        }

        return result.toString();
    }
}
