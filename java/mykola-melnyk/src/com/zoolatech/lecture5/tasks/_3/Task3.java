package com.zoolatech.lecture5.tasks._3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
    public static Set<CustomString> uniqStr2(String... words) {
        ArrayList<CustomString> arrayListOfCustomString = new ArrayList<>();
        for (String string:words) {
            arrayListOfCustomString.add(new CustomString(string));
        }
        return new HashSet<CustomString>(arrayListOfCustomString);
    }

    public static void main(String[] args) {
        System.out.println(Task3.uniqStr2("apple", "Apple", "Banana", "banana"));
        System.out.println(Task3.uniqStr2("apple", "orange", "pear", "apple", "banana", "orange"));
    }
}
