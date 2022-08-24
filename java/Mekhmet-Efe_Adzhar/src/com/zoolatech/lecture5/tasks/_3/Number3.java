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

public class Number3 {
    public static void main(String[] args) {
        ArrayList<String> fruitList = new ArrayList<>();
        fruitList.add("Apple");
        fruitList.add("orange");
        fruitList.add("pear");
        fruitList.add("apple");
        fruitList.add("banana");
        fruitList.add("orange");

        Number3 number3 = new Number3();
        System.out.println(number3.uniqueWords(fruitList));
    }

    public ArrayList<String> uniqueWords(ArrayList<String> fruitList) {
        for (int i = 0; i < fruitList.size(); i++) {
            for (int j = i + 1; j < fruitList.size(); j++) {
                if (fruitList.get(i).equalsIgnoreCase(fruitList.get(j))) {
                    fruitList.remove(j);
                    j--;
                }
            }
        }
        return fruitList;
    }
}