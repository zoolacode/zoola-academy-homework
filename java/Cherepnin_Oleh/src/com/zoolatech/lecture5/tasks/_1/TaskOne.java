package com.zoolatech.lecture5.tasks._1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Create a method that accepts an integer N and a variable amount of other integer numbers. The method needs to return
 * the value of the Nth (1-based) smallest element in the array. Return -1 if the amount of passed integers is
 * less than N.
 * Input: 4, 1, 5, 2, 3, 7
 * Output: 5 (the 4th smallest number in the array 1, 5, 2, 3, 7 is 5: 1 2 3 5 7)
 * Input: 3, 1, 2
 * Output: -1
 */
public class TaskOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input N number:");
        int n = scanner.nextInt();
        int[] ints = getIntsFromInput(scanner);
        System.out.println(findNSmallestNumber(n, ints));
    }

    private static int[] getIntsFromInput(Scanner scanner) {
        System.out.println("Input numbers separated by commas");
        int[] ints = Arrays.stream(scanner.next().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        return ints;
    }

    public static String findNSmallestNumber(int n, int... array) {
        if (n >= array.length) {
            return "-1";
        }
        int[] ints = copyArray(array);
        Arrays.sort(ints);
        int nSmallest = ints[n - 1];
        StringBuilder builder = new StringBuilder();
        return builder.append(nSmallest).append(" (the ").append(n)
                .append("th smallest number in the array: ")
                .append(Arrays.toString(array))
                .append(" is ").append(nSmallest)
                .append(": ")
                .append(Arrays.toString(ints)).toString();
    }

    private static int[] copyArray(int[] array) {
        int[] ints = Arrays.copyOf(array, array.length);
        for (int i = 0; i < ints.length; i++) {
            ints[i] = array[i];
        }
        return ints;
    }
}
