package com.zoolatech.lecture5.tasks._3;

import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Create a method that accepts a list of words, and displays only unique one (order can be random).
 * Bonus task: treat strings in a different case as the same one: “Apple” and “apple” should be treated
 * as the same string (don’t use any methods that create a new string object - like toUpperCase or toLowerCase -
 * you can work only with a given input).
 */

public class Task3 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "orange", "pear", "apple", "banana", "orange", "Banana");
        withoutRepeatsSet(fruits);
        System.out.println("\n");
        withoutRepeatsCase(fruits);
    }

    public static void withoutRepeatsSet(List<String> stringList) {
        HashSet<String> hashSet = new HashSet<>(stringList);
        for (String str : hashSet) {
            System.out.println(str);
        }
    }

    public static void withoutRepeatsCase(List<String> stringList) {
        // bonus task
        TreeSet<String> treeSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        treeSet.addAll(stringList);
        for (String str : treeSet) {
            System.out.println(str);
        }
    }
}
