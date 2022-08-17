package com.zoolatech.lecture10.tasks._1;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Given a directory called db with 3 files:
 * names (Ex. of content Alex, John, Maria)
 * surnames (Scott, Fung, Chan)
 * positions (Delivery Manager, Senior Java Dev, Product Manager)
 * <p>
 * When user starts app it can see in terminal list of files without content.
 * User can type file name like "names" and see content of the file on terminal.
 * If user type invalid filename app should write message to err stream,
 * draw file names again and write invalid filename to a new file called "error.log" (ideally data should be appended).
 */

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String directionToTaskFolder = "src/com/zoolatech/lecture10/tasks/_1/";
        File folder = new File(directionToTaskFolder + "db");

        ArrayList<String> filesList = new ArrayList<>();
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            filesList.add(file.getName());
            System.out.println(file.getName());
        }

        System.out.println("Choose the file " + filesList + " :");
        String userChoice;

        do {
            userChoice = scanner.next().toLowerCase();
            if (userChoice.equals("names") ||
                    userChoice.equals("surnames") ||
                    userChoice.equals("positions")) {

                try (BufferedReader reader = new BufferedReader(new FileReader(directionToTaskFolder + "db/"
                        + userChoice))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try (RandomAccessFile file = new RandomAccessFile(directionToTaskFolder + "error.log", "rw")
                ) {
                    String errorMessage = "File with name \"" + userChoice + "\" does not exist";
                    file.seek(file.length());
                    file.writeBytes("\n" + errorMessage);

                    System.out.println(errorMessage);
                    System.out.println("Choose the file " + filesList);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } while (!filesList.contains(userChoice));
    }
}
