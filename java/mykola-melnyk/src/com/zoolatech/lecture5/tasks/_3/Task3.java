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
    public static Set<CustomString> uniqStr2(String... words) {
        ArrayList<CustomString> arrayListOfCustomString = new ArrayList<>();
        for (String string : words) {
            arrayListOfCustomString.add(new CustomString(string));
        }
        return new HashSet<>(arrayListOfCustomString);
    }

    public static Set<CustomString> uniqStr3(String... words) {
        ArrayList<CustomString> arrayListOfCustomString = new ArrayList<>();
        for (String string : words) {
            arrayListOfCustomString.add(new CustomString(string));
        }
        return new TreeSet<>(arrayListOfCustomString);
    }

    public static Set<String> uniqStr4(String... words) {
        TreeSet<String> myTreeSet = new TreeSet<>(new CaseAgnosticComparator());
        myTreeSet.addAll(Arrays.asList(words));
        return myTreeSet;
    }

    public static Set<String> uniqStr5(String... words) {

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.equalsIgnoreCase(o2)) {
                    return 0;
                }
                return o1.compareTo(o2);
            }
        };
        TreeSet<String> myTreeSet = new TreeSet<>(comparator);
        myTreeSet.addAll(Arrays.asList(words));
        return myTreeSet;
    }

    public static Set<String> uniqStr6(String... words) {

        Comparator<String> comparator = (o1, o2) -> {
            if (o1.equalsIgnoreCase(o2)) {
                return 0;
            }
            return o1.compareTo(o2);
        };
        TreeSet<String> myTreeSet = new TreeSet<>(comparator);
        myTreeSet.addAll(Arrays.asList(words));
        return myTreeSet;
    }

    public static Set<String> uniqStr7(String... words) {
        Comparator<String> comparator = new CaseAgnosticComparator()::compare;
        TreeSet<String> myTreeSet = new TreeSet<>(comparator);
        myTreeSet.addAll(Arrays.asList(words));
        return myTreeSet;
    }

    public static void main(String[] args) {
//        System.out.println(Task3.uniqStr2("apple", "Apple", "Banana", "banana"));
        System.out.println(Task3.uniqStr4("apple", "Apple", "orange", "pear", "apple", "banana", "orange"));
        System.out.println(Task3.uniqStr5("apple", "Apple", "orange", "pear", "apple", "banana", "orange"));
        System.out.println(Task3.uniqStr6("apple", "Apple", "orange", "pear", "apple", "banana", "orange"));
        System.out.println(Task3.uniqStr7("apple", "Apple", "orange", "pear", "apple", "banana", "orange"));
    }
}
