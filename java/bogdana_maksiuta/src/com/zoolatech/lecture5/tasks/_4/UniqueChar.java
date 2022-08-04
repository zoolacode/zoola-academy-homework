package com.zoolatech.lecture5.tasks._4;

import java.util.Map;
import java.util.TreeMap;

/**
 * Create a method that accepts a string, counts all unique non-space character
 * occurrences and displays each character with an amount of occurrences
 * (output should be sorted by a character value in ascending order).
 * Also, add a couple of examples that use your method.
 * Input: “Hello World”
 * Output: H - 1
 * W - 1
 * d - 1
 * e - 1
 * l - 3
 * o - 2
 * r - 1
 */
public class UniqueChar {

    public static void main(String[] args) {
        String text = "Hello World";
        System.out.println("Text before modifier: \n" + text);
        Map<Character, Integer> characterIntegerMap = countUniqueChar(text);
        output(characterIntegerMap);

        String text2 = "You know my methods, Watson";
        System.out.println("Text before modifier: \n" + text2);
        Map<Character, Integer> characterIntegerMap2 = countUniqueChar(text2);
        output(characterIntegerMap2);
    }

    static Map<Character, Integer> countUniqueChar(String text) {
        String textChanged = text.replaceAll("\\s", "");

        Map<Character, Integer> lettersCounter = new TreeMap<>();

        for (char c : textChanged.toCharArray()) {
            if (!lettersCounter.containsKey(c)) {
                lettersCounter.put(c, 1);
            } else {
                int i = lettersCounter.get(c);
                lettersCounter.put(c, ++i);
            }
        }
        return lettersCounter;
    }

    static void output(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
