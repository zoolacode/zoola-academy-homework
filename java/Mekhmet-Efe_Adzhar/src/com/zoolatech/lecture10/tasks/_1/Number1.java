package com.zoolatech.lecture10.tasks._1;

/*
Given a directory called db with 3 files:
names (Ex. of content Alex, John, Maria)
surnames (Scott, Fung, Chan)
positions (Delivery Manager, Senior Java Dev, Product Manager)

When user starts app it can see in terminal list of files without content.
User can type file name like "names" and see content of the file on terminal.
If user type invalid filename app should write message to err stream,
draw file names again and write invalid filename to a new file called "error.log" (ideally data should be appended).
*/

import java.io.IOException;
import java.util.Scanner;

public class Number1 {
    public static void main(String[] args) throws IOException {
        System.out.println("1. Start\n2. Exit");
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        while (scanner.nextInt() != 2) {
            menu.menu();
        }
    }
}