package com.zoolatech.lecture5.tasks._3;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Create a method that accepts a list of words, and displays only unique one
 * (order can be random). Bonus task: treat strings in a different case as the
 * same one: “Apple” and “apple” should be treated as the same string (don’t
 * use any methods that create a new string object - like toUpperCase or
 * toLowerCase - you can work only with a given input).
 */

public class Task3 {
    public static void main(String[] args) {
        printUniq(new String[]{"apple", "orange", "pear", "Apple", "banana", "orange"});
    }

    public static void printUniq(String[] list) {
        Set<String> strings = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        strings.addAll(Arrays.asList(list));
        strings.forEach(System.out::println);
    }
}
