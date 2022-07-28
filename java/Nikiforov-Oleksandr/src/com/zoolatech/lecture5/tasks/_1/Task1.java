package com.zoolatech.lecture5.tasks._1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Create a method that accepts an integer N and a variable amount of other integer numbers.
 * The method needs to return the value of the Nth (1-based) smallest element in the array.
 * Return -1 if the amount of passed integers is less than N.
 */

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input N: ");
        int n = sc.nextInt();
        ArrayList<Integer> arrayList = createArrayList();
        findValue(arrayList, n);
    }

    public static ArrayList<Integer> createArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input list value(Input -1 to stop): ");
            int inputInt = sc.nextInt();
            if (inputInt == -1) {
                break;
            }
            arrayList.add(inputInt);
        }
        return arrayList;
    }

    public static void findValue(ArrayList<Integer> arrayList, int n) {
        if (arrayList.size() < n) {
            System.out.println(-1);
            return;
        }
        ArrayList<Integer> sortedList = new ArrayList<>(arrayList);
        Collections.sort(sortedList);
        int value = sortedList.get(n - 1);
        System.out.println(value + "(the " + n + "th smallest number in the array " + arrayList + " is " + value + ":" + sortedList + ")");
    }
}
