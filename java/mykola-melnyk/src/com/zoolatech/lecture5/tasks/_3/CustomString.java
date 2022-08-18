package com.zoolatech.lecture5.tasks._3;

import java.util.Objects;

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


public class CustomString implements Comparable<CustomString> {
    private final String string;

    public CustomString(String aString) {
        this.string = aString;
    }

    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        CustomString other = (CustomString) otherObject;
        return string.equalsIgnoreCase(other.string);
    }

    public int hashCode() {
        return Objects.hash(string.toLowerCase());
    }

    @Override
    public String toString() {
        return string.toLowerCase();
    }

    @Override
    public int compareTo(CustomString o) {
        if (string.equalsIgnoreCase(o.string)) {
            return 0;
        }
        return string.compareTo(o.string);
    }
}
