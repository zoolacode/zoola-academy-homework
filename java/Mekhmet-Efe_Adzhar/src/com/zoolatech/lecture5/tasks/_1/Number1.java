package com.zoolatech.lecture5.tasks._1;

/*
Create a method that accepts an integer N and a variable amount of other integer numbers.
The method needs to return the value of the Nth (1-based) smallest element in the array.
Return -1 if the amount of passed integers is less than N.
Input: 4, 1, 5, 2, 3, 7
Output: 5 (the 4th smallest number in the array 1, 5, 2, 3, 7 is 5: 1 2 3 5 7)
Input: 3, 1, 2
Output: -1
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Number1 {
    ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4;
        Number1 number1 = new Number1();
        number1.task(n, 1, 5, 2, 3, 7);
    }

    public void task(int n, int... variables) {
        if (n > variables.length + 1) {
            System.out.println(-1);
        } else {
            for (int variable : variables) {
                arrayList.add(variable);
            }
        }
        Collections.sort(arrayList);
        System.out.print(arrayList.get(n - 1) + " (the " + n + "th smallest number in the array ");
        System.out.println(Arrays.toString(variables) + " is " + arrayList.get(n - 1) + ": " + arrayList);
    }
}