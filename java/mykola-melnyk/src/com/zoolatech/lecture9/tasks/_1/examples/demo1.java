package com.zoolatech.lecture9.tasks._1.examples;

import java.util.Scanner;

class Scratch {

    // Read data from terminal and write it to terminal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Printing the data passed in:");
//        while (sc.hasNextLine()) System.out.println("Your message -> " + sc.nextLine());
        while (sc.hasNextLine()) System.err.println("Your message -> " + sc.nextLine());
    }
}