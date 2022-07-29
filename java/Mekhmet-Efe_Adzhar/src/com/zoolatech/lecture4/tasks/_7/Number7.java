package com.zoolatech.lecture4.tasks._7;

/*Create a method that accepts a string of digits and after each digit appends its string representation in parentheses
	Input: “12345”
Output: “1(one)2(two)3(three)4(four)5(five)”
*/

import java.util.Map;
import java.util.TreeMap;

public class Number7 {
    public static void main(String[] args) {
        String string = "12345";
        StringRepresentDigits stringRepresentDigits = new StringRepresentDigits();
        stringRepresentDigits.representStringDigets(string);
    }
}

class StringRepresentDigits {

    public void representStringDigets(String string) {
        Map<Integer, String> numbersMap = new TreeMap<Integer, String>();
        numbersMap.put(1, "one");
        numbersMap.put(2, "two");
        numbersMap.put(3, "three");
        numbersMap.put(4, "four");
        numbersMap.put(5, "five");

        int[] ints = new int[string.length() + 1];
        for (int i = 0; i <= string.length(); i++) {
            ints[i] = i;
        }

        for (Map.Entry<Integer, String> entry : numbersMap.entrySet()) {
            for (int i = 0; i <= ints.length + 1; i++) {
                if (entry.getKey() == i) {
                    System.out.print(entry.getKey() + "(" + entry.getValue() + ")" + ' ');
                }
            }
        }
    }
}