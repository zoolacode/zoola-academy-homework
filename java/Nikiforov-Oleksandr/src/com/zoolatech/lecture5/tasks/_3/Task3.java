package com.zoolatech.lecture5.tasks._3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Create a method that accepts a list of words, and displays only unique one (order can be random).
 * Bonus task: treat strings in a different case as the same one: “Apple” and “apple” should be treated
 * as the same string (don’t use any methods that create a new string object - like toUpperCase or toLowerCase -
 * you can work only with a given input).
 */

public class Task3 {
    public static void main(String[] args) {
        String[] arrString = {"apple", "orange", "pear", "apple", "banana", "orange", "Banana"};
        withoutRepeatsSet(arrString);
        System.out.println("\n\n");
        withoutRepeatsCase(arrString);
    }

    public static void withoutRepeatsSet(String[] arrString) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(arrString));
        for (String str : hashSet) {
            System.out.println(str);
        }
    }

    public static void withoutRepeatsCase(String[] arrString) {
        //bonus task
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : arrString) {
            if (checkerCase(str, arrayList)) {
                arrayList.add(str);
            }
        }
        for (String str : arrayList) {
            System.out.println(str);
        }
    }


    public static boolean checkerCase(String inputString, ArrayList<String> arrayList) {
        for (String str : arrayList) {
            if (inputString.equalsIgnoreCase(str)) {
                return false;
            }
        }
        return true;
    }
}
