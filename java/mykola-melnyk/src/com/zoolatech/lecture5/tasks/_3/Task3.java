package com.zoolatech.lecture5.tasks._3;

import java.util.*;

/**
 * Create a method that accepts a list of words, and displays only unique one (order can be random). Bonus task:
 * treat strings in a different case as the same one: “Apple” and “apple” should be treated as the same string
 * (don’t use any methods that create a new string object - like toUpperCase or toLowerCase - you can work only
 * with a given input).
 * Input: [“apple”, “orange”, “pear”, “apple”, “banana”, “orange”]
 * Output: apple
 * orange
 * pear
 * banana
 */

public class Task3 {

    public static Set<String> uniqStr7(String... words) {
        Comparator<String> comparator = new CaseAgnosticComparator()::compare;
        TreeSet<String> myTreeSet = new TreeSet<>(comparator);
        myTreeSet.addAll(Arrays.asList(words));
        return myTreeSet;
    }

    public static void main(String[] args) {
        System.out.println(Task3.uniqStr7("apple", "Apple", "orange", "pear", "apple", "banana", "orange"));
    }
}
