package com.zoolatech.lecture4.tasks._7;

public class DigitToString {

    public static void convertToWord(String stringOfDigits) {
        char[] chars = stringOfDigits.toCharArray();
        for (Character character : chars) {
            System.out.print(character + "(" + digitToString(character) + ")");
        }
    }
    public static String digitToString(char digit) {
        switch (digit) {
            case '1' -> {
                return "one";
            }
            case '2' -> {
                return "two";
            }
            case '3' -> {
                return "three";
            }
            case '4' -> {
                return "four";
            }
            case '5' -> {
                return "five";
            }
            case '6' -> {
                return "six";
            }
            case '7' -> {
                return "seven";
            }
            case '8' -> {
                return "eight";
            }
            case '9' -> {
                return "nine";
            }
            case '0' -> {
                return "zero";
            }
            default -> {
                return "Not a Digit!";
            }
        }
    }
}
