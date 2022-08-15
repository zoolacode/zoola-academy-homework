package com.zoolatech.lecture5.tasks._3;

import java.util.List;
import java.util.TreeSet;

/**
 * Create a method that accepts a list of words, and displays only
 * unique one (order can be random). Bonus task: treat strings in a
 * different case as the same one: “Apple” and “apple” should be
 * treated as the same string (don’t use any methods that create a
 * new string object - like toUpperCase or toLowerCase - you can
 * work only with a given input).
 * Input: [“apple”, “orange”, “pear”, “apple”, “banana”, “orange”]
 * Output: apple
 *             orange
 *             pear
 *             banana
 */

public class Task3 {

    public static void main(String[] args) {
        displayUniqueWords(List.of("apple", "orange", "pear", "Apple", "banana", "orange"));
    }

    public static void displayUniqueWords(List<String> list) {
        TreeSet<String> unique = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        list.stream().filter(unique::add).forEach(System.out::println);
    }
}
