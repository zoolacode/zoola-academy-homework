package com.zoolatech.lecture5.tasks._4;

import java.util.HashMap;

/**
 * Create a method that accepts a string, counts all unique non-space character occurrences and displays each character
 * with an amount of occurrences (output should be sorted by a character value in ascending order).
 * Also, add a couple of examples that use your method.
 */

public class Task4 {
    public static void main(String[] args) {
        String inputStr1 = "Hello World";
        String inputStr2 = "London is the capital of Great Britain";
        countCharacters(inputStr1);
        countCharacters(inputStr2);
    }

    public static void countCharacters(String inputStr) {
        char[] charArray = inputStr.replaceAll("\\s+","").toCharArray();
        HashMap<Character, Integer> charHashMap = new HashMap<Character, Integer>();
        for (char c : charArray) {
            if (charHashMap.containsKey(c)) {
                charHashMap.put(c, charHashMap.get(c) + 1);
            } else {
                charHashMap.put(c, 1);
            }
        }
        System.out.println(inputStr);
        for (HashMap.Entry element : charHashMap.entrySet()) {
            System.out.println(element.getKey() + " - " + element.getValue());
        }
    }
}
