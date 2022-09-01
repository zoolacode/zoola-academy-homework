package com.zoolatech.lecture5.tasks._4;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Create a method that accepts a string, counts all unique non-space character
 * occurrences and displays each character with an amount of occurrences (output
 * should be sorted by a character value in ascending order). Also, add a couple
 * of examples that use your method.
 */

public class Task4 {
    public static void main(String[] args) {
        countCharacters("Hello World");
    }

    public static void countCharacters(String line) {
        SortedMap<Character, Integer> sortedMap = new TreeMap<>();

        for (char ch : line.toCharArray()) {
            if (ch != ' ') {
                sortedMap.put(ch, sortedMap.getOrDefault(ch, 0) + 1);
            }
        }

        sortedMap.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
