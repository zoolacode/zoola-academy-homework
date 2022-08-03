package com.zoolatech.lecture5.tasks._3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Create a method that accepts a list of words, and displays only unique one (order can be random).
 *
 * Bonus task: treat strings in a different case as the same one: “Apple” and “apple” should be treated
 * as the same string (don’t use any methods that create a new string object -
 * like toUpperCase or toLowerCase - you can work only with a given input).
 *         a. Input: [“apple”, “orange”, “pear”, “apple”, “banana”, “orange”]
 * Output: apple
 * 			orange
 * 			pear
 * 			banana
 */
public class UniqueElements {

    static void uniqueWords (List<String> words) {
        HashSet<String> wordsHashSet = new HashSet<>(words);
        System.out.println(wordsHashSet);

        Set<String> wordsSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER); //bonus task
        wordsSet.addAll(words);
        System.out.println(wordsSet);
    }

    public static void main(String[] args) {
        List<String> fruits = List.of("apple","orange", "pear", "apple", "banana", "oRange");
        uniqueWords(fruits);
    }
}

