package com.zoolatech.lecture4.tasks._7;

import java.util.Arrays;

public class DigitToString {

    public static String convertToWord(char digit) {
        String word = null;
        switch (digit) {
            case '1' -> word = "one";
            case '2' -> word = "two";
            case '3' -> word = "three";
            case '4' -> word = "four";
            case '5' -> word = "five";
            case '6' -> word = "six";
            case '7' -> word = "seven";
            case '8' -> word = "eight";
            case '9' -> word = "nine";
            case '0' -> word = "zero";
            default -> word = "Not a Digit!";
        }
        return word;
    }
    public static void digitToString (String stringOfDigits) {
        int length = stringOfDigits.length();
        char[] chars = new char[length];
        stringOfDigits.getChars(0, length, chars, 0);
        for (Character e : chars) {
            System.out.print(e + "(" + convertToWord(e) + ")");
        }
    }
}
