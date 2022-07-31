package com.zoolatech.lecture4.tasks._7;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        if (string.matches("[0-9]+") && string.length() > 2) {
            return Stream.of(string)
                    .map(s -> s.split("")).
                    flatMap(s -> Arrays.stream(s).sequential())
                    .map(s -> check(s))
                    .collect(Collectors.joining());
        } else {
            throw new IllegalArgumentException("Pls, enter numbers only!");
        }
    }

    public static String check(String string) {
        switch (string) {
            case "1" -> {return string + "(one)";}
            case "2" -> {return string + "(two)";}
            case "3" -> {return string + "(three)";}
            case "4" -> {return string + "(four)";}
            case "5" -> {return string + "(five)";}
            case "6" -> {return string + "(six)";}
            case "7" -> {return string + "(seven)";}
            case "8" -> {return string + "(eight)";}
            case "9" -> {return string + "(nine)";}
            case "0" -> {return string + "(zero)";}
            default -> {return string + "(incorrect)";}
        }
    }
}
