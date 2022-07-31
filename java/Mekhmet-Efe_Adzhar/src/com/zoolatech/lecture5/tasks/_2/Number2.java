package com.zoolatech.lecture5.tasks._2;

/*Create a generic method that accepts a list of values (not only numbers) and returns the max value.
Input:  1, 5, 7, 3, 5
Output:
*/

import java.util.*;

public class Number2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(5);
        System.out.println(largestElement(list));
    }

    public static <T extends Comparable<T>> T largestElement(List<T> list) {
        T value = list.get(0);
        for (int i = 0; i < list.size() - 1; i++) {
            if (value.compareTo(list.get(i + 1)) < 0) {
                value = list.get(i + 1);
            }
        }
        return value;
    }
}