package com.zoolatech.lecture4.tasks._7;

import java.util.stream.Collectors;

/**
 * Create a method that accepts a string of digits and after each digit
 * appends its string representation in parentheses.
 */

public class Task7 {
    public static void main(String[] args) {
        String string = "12345678910";
        System.out.println(stringRepresentation(string));
    }

    public static String stringRepresentation(String string) {
        if (string.matches("[0-9]+")) {
            return string.chars()
                    .mapToObj(c -> (char) c)
                    .map(Task7::charConverter)
                    .collect(Collectors.joining());
        } else {
            throw new IllegalArgumentException("Pls, enter valid numbers only!");
        }
    }

    public static String charConverter(char character) {
        return switch (character) {
            case '1' -> character + "(one)";
            case '2' -> character + "(two)";
            case '3' -> character + "(three)";
            case '4' -> character + "(four)";
            case '5' -> character + "(five)";
            case '6' -> character + "(six)";
            case '7' -> character + "(seven)";
            case '8' -> character + "(eight)";
            case '9' -> character + "(nine)";
            case '0' -> character + "(zero)";
            default -> throw new IllegalArgumentException("incorrect value");
        };
    }
}

