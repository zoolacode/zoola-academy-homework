package com.zoolatech.lecture5.tasks._4;

import java.util.TreeMap;
import java.util.stream.Collectors;

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
        str.chars()
                .mapToObj(c -> (char) c)
                .filter(e -> !e.equals(' '))
                .collect(Collectors.groupingBy(s -> s, TreeMap::new, Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " - " + v));
    }
}
