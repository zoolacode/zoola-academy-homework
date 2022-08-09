package com.zoolatech.java.solomiia_tymoshchuk.src.lecture1.tasks._7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Write a program that prints all odd numbers from N to 1.
 * N should be read from the input.
 * Every number should be printed on the new line.
 * Create two versions of the program: one should use the for loop,
 * second - the while loop.
 **/
public class Task7 {
    int number;
    public Task7(int number){
        this.number = number;
    }
    List<Integer> newarr = new ArrayList<>();

    void oddNumbers() {
        for (int k = number; k > 0; k--) {
            if (k % 2 != 0) {
                System.out.println(k);
            }
        }
    }

    void oddNumbersWhile() {
        int i = number;
        while (i >= 0) {
            if (i % 2 != 0) {
                newarr.add(i);
            }
            i--;
        }
        newarr.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        Task7 task7 = new Task7(sc.nextInt());
//        task7.oddNumbersWhile();
        task7.oddNumbers();
    }
}
