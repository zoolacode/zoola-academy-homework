package com.zoolatech.lecture5.tasks._1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Create a method that accepts an integer N and a variable amount of other integer numbers.
 * The method needs to return the value of the Nth (1-based) smallest element in the array.
 * Return -1 if the amount of passed integers is less than N.
 */

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input: ");

        String[] inputNumbers = sc.nextLine().split(", ");
        int n = getN(inputNumbers);
        int[] numbers = getNumbers(inputNumbers);
        int[] sortedNumbers = getSortedNumbers(numbers);

        int foundNumber = findNthSmallest(n, sortedNumbers);

        if (foundNumber == -1) {
            System.out.println(-1);
        } else {
            System.out.println(foundNumber + "(the " + n + "th smallest number in the array " + Arrays.toString(numbers) + " is " + foundNumber + ": " + Arrays.toString(sortedNumbers) + ")");
        }
    }

    private static int getN(String[] inputNumbers) {
        return Integer.parseInt(inputNumbers[0]);
    }

    private static int[] getNumbers(String[] inputNumbers) {
        int arrLength = inputNumbers.length - 1;
        int[] intNumbers = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            intNumbers[i] = Integer.parseInt(inputNumbers[i + 1]);
        }
        return intNumbers;
    }

    public static int[] getSortedNumbers(int[] numbers) {
        int[] sortedNumbers = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedNumbers);
        return sortedNumbers;
    }

    public static int findNthSmallest(int n, int... numbers) {
        int foundValue = -1;
        if (numbers.length >= n) {
            foundValue = numbers[n - 1];
        }
        return foundValue;
    }
}
