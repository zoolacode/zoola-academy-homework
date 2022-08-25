package com.zoolatech.lecture4.tasks._7;

/*Create a method that accepts a string of digits and after each digit appends its string representation in parentheses
	Input: “12345”
Output: “1(one)2(two)3(three)4(four)5(five)”
*/

import java.util.Map;
import java.util.TreeMap;

public class Number7 {
    public static void main(String[] args) {
        String string = "54321";
        StringRepresentDigits stringRepresentDigits = new StringRepresentDigits();
        stringRepresentDigits.representStringDigits(string);
    }
}

class StringRepresentDigits {

    public void representStringDigits(String string) {
        Map<Integer, String> numbersMap = new TreeMap<>();
        numbersMap.put(0, "zero");
        numbersMap.put(1, "one");
        numbersMap.put(2, "two");
        numbersMap.put(3, "three");
        numbersMap.put(4, "four");
        numbersMap.put(5, "five");
        numbersMap.put(6, "six");
        numbersMap.put(7, "seven");
        numbersMap.put(8, "eight");
        numbersMap.put(9, "nine");

        int[] ints = new int[string.length()];
        for (int i = 0; i < string.length(); i++) {
            ints[i] = Integer.parseInt(String.valueOf(string.charAt(i)));
        }

        for (int i = 0; i <= ints.length - 1; i++) {
            System.out.print(ints[i] + "(" + numbersMap.get(ints[i]) + ") ");
        }
    }
}