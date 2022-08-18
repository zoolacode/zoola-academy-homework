package com.zoolatech.lecture5.tasks._4;

import java.util.*;

/**
 * Create a method that accepts a string, counts all unique non-space character occurrences and
 * displays each character with an amount of occurrences (output should be sorted by a character
 * value in ascending order). Also, add a couple of examples that use your method.
 * Input: “Hello World”
 * Output: H - 1
 * W - 1
 * d - 1
 * e - 1
 * l - 3
 * o - 2
 * r - 1
 */

public class Task4 {
    public static void charOccur(String string) {   // method 1;
        string = string.replaceAll(" ", ""); // removed spaces
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        string = new String(chars);  // sorted alphabetically
        System.out.println(string);  // test, to see if the string is as we want
        HashMap<Character, Integer> charTable = new LinkedHashMap<>();  //create hashmap
        int length = string.length();
        Character ch;
        for (int i = 0; i < length; i++) {
            ch = string.charAt(i);
            if (charTable.containsKey(ch)) {
                charTable.put(ch, charTable.get(ch) + 1);
            } else {
                charTable.put(ch, 1);
            }
        }
        customMapPrint(charTable);
    }

    private static void charOccur2(String string) {  // method 2, using treemap and iterator
        TreeMap<Character, Integer> myMap = new TreeMap<>();
        for (int i = 0; i < string.length(); i++) {
            Character ch = string.charAt(i);
            if (ch != ' ') {
                if (myMap.containsKey(ch)) {
                    myMap.put(ch, myMap.get(ch) + 1);
                } else {
                    myMap.put(ch, 1);
                }
            }
        }
        customMapPrint(myMap);
    }

    private static void charOccur3(String string) { // method 3, using treemap, array and for each loop
        TreeMap<Character, Integer> myMap = new TreeMap<>();
        char[] chars = string.toCharArray();
        for (char ch : chars) {
            if (ch != ' ') {
                if (myMap.containsKey(ch)) {
                    myMap.put(ch, myMap.get(ch) + 1);
                } else {
                    myMap.put(ch, 1);
                }
            }
        }
        customMapPrint(myMap);
    }

    private static void customMapPrint(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {  // print output
            System.out.print(entry.getKey() + " - ");
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        Task4.charOccur("Hello World");
        Task4.charOccur2("Hello World");
        Task4.charOccur3("Hello World");
    }

}
