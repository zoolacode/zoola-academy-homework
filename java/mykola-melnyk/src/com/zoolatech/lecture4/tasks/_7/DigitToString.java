package com.zoolatech.lecture4.tasks._7;

public class DigitToString {

    public static void convertToWord(String stringOfDigits) {
        char[] chars = stringOfDigits.toCharArray();
        for (Character character : chars) {
            System.out.print(character + "(" + digitToString(character) + ")");
        }
    }
    public static String digitToString(char digit) {
        return switch (digit) {
            case '1' -> "one";
            case '2' -> "two";
            case '3' -> "three";
            case '4' -> "four";
            case '5' -> "five";
            case '6' -> "six";
            case '7' -> "seven";
            case '8' -> "eight";
            case '9' -> "nine";
            case '0' -> "zero";
            default -> "Not a Digit!";
        };
    }
}
