package com.zoolatech.lecture4.tasks._7;

/**
 * Create a method that accepts a string of digits and after each
 * digit appends its string representation in parentheses
 *
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
            switch (ch) {
                case '1' -> result.append("1(one)");
                case '2' -> result.append("2(two)");
                case '3' -> result.append("3(three)");
                case '4' -> result.append("4(four)");
                case '5' -> result.append("5(five)");
                case '6' -> result.append("6(six)");
                case '7' -> result.append("7(sever)");
                case '8' -> result.append("8(eight)");
                case '9' -> result.append("9(nine)");
                case '0' -> result.append("0(zero)");
            }
        }

        return result.toString();
    }
}
