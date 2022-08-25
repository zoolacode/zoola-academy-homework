package com.zoolatech.lecture5.tasks._3;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Create a method that accepts a list of words, and displays only unique one (order can be random).
 * Bonus task: treat strings in a different case as the same one: “Apple” and “apple” should be treated
 * as the same string (don’t use any methods that create a new string object - like toUpperCase or
 * toLowerCase - you can work only with a given input).
 * Input: [“apple”, “orange”, “pear”, “apple”, “banana”, “orange”]
 * Output: apple
 * orange
 * pear
 * banana
 */
public class TaskThree {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "Apple", "orange", "orange", "pear", "peach", "Pear", "peach");
        displayUnique(fruits);
        System.out.println("------------------------------------");
        displayUniqueIgnoreCase(fruits);
    }

    static void displayUnique(List<String> list) {
        Set<String> uniqueValues = new HashSet<>(list);
        uniqueValues.forEach(System.out::println);
    }

    static void displayUniqueIgnoreCase(List<String> list) {
        Set<String> uniqueValues = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        uniqueValues.addAll(list);
        uniqueValues.forEach(System.out::println);
    }
}
