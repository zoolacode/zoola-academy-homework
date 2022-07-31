package com.zoolatech.lecture5.tasks._3;

/*
Create a method that accepts a list of words, and displays only unique one (order can be random).
Bonus task: treat strings in a different case as the same one: “Apple” and “apple” should be treated as the same string
(don’t use any methods that create a new string object - like toUpperCase or toLowerCase - you can work only with a given input).
Input: [“apple”, “orange”, “pear”, “apple”, “banana”, “orange”]
Output: apple
		orange
		pear
		banana
 */

import java.util.ArrayList;
import java.util.List;

public class Number3 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("orange");
        stringList.add("pear");
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("orange");

        Number3 number3 = new Number3();
        System.out.println(number3.uniqueWords(stringList));
    }

    public List<String> uniqueWords(List<String> stringList) {
        for (int i = 0; i < stringList.size(); i++) {
            for (int j = i + 1; j < stringList.size(); j++) {
                if (stringList.get(i).equals(stringList.get(j))) {
                    stringList.remove(j);
                    j--;
                }
                if (stringList.get(i).equalsIgnoreCase(stringList.get(j))) {
                    stringList.remove(j);
                    j--;
                }
            }
        }
        return stringList;
    }
}