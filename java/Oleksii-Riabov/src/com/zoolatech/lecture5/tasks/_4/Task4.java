package com.zoolatech.lecture5.tasks._4;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Create a method that accepts a string, counts all unique non-space character
 * occurrences and displays each character with an amount of occurrences
 * (output should be sorted by a character value in ascending order). Also, add
 * a couple of examples that use your method.
 * Input: “Hello World”
 * Output: H - 1
 * W - 1
 * d - 1
 * e - 1
 * l - 3
 * o - 2
 * r - 1
 */

public class Task4 {

    public static void main(String[] args) {
        countUniqueCharacters("Hello World");
        System.out.println();
        countUniqueCharacters("displays each character");
        System.out.println();
        countUniqueCharacters("In Ascending Order");
    }

    public static void countUniqueCharacters(String str) {
        Stream.of(str.replaceAll("\\s+", "").split(""))
                .sorted()
                .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " - " + v));
    }
}
