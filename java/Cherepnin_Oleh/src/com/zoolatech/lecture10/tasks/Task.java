package com.zoolatech.lecture10.tasks;

import java.util.Scanner;

/**
 * Given a directory called db with 3 files:
 * names (Ex. of content Alex, John, Maria)
 * surnames (Scott, Fung, Chan)
 * positions (Delivery Manager, Senior Java Dev, Product Manager)
 * <p>
 * When user starts app it can see in terminal list of files without content. User can type file name like
 * "names" and see content of the file on terminal.
 * If user type invalid filename app should write message to err stream, draw file names again and write invalid
 * filename to a new file called "error.log" (ideally data should be appended).
 */

public class Task {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader("src/com/zoolatech/lecture10/tasks/db/");
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        do {
            System.out.println("Input file name (" + fileReader.getFilesAsString() + "):");
            String fileName = scanner.next();
            fileReader.readFile(fileName);
            System.out.println("Repeat operation (press 'Y' to repeat):");
            answer = scanner.next();
        } while ("Y".equalsIgnoreCase(answer));
    }
}