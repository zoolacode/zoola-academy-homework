package com.zoolatech.lecture10.tasks._1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Given a directory called db with 3 files:
 * names (Ex. of content Alex, John, Maria)
 * surnames (Scott, Fung, Chan)
 * positions (Delivery Manager, Senior Java Dev, Product Manager)
 * <p>
 * When user starts app it can see in terminal list of files without content.
 * User can type file name like "names" and see content of the file on terminal.
 * If user type invalid filename app should write message to err stream, draw file
 * names again and write invalid filename to a new file called "error.log"
 * (ideally data should be appended).
 */

public class Task1 {

    private static final File DIR = new File("db");

    public static void main(String[] args) {
        List<String> namesList = List.of("Alex", "John", "Maria");
        List<String> surnamesList = List.of("Scott", "Fung", "Chan");
        List<String> positionsList = List.of("Delivery Manager", "Senior Java Dev", "Product Manager");

        DIR.mkdir();

        writeFile("names", namesList);
        writeFile("surnames", surnamesList);
        writeFile("positions", positionsList);

        showFiles();
    }

    public static void writeFile(String filename, List<String> elementsList) {
        try (FileWriter writer = new FileWriter(DIR.getName() + "/" + filename, StandardCharsets.UTF_8, true)) {
            for (String element : elementsList) {
                writer.write(element + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showFiles() {
        printFiles();

        do {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine().toLowerCase();
            if ("exit".equals(line)) {
                break;
            }

            String result = "";
            for (File file : DIR.listFiles()) {
                if (file.getName().equals(line)) {
                    try (InputStream inputStream = new FileInputStream(file)) {
                        result = new BufferedReader(new InputStreamReader(inputStream))
                                .lines()
                                .collect(Collectors.joining("\n"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            if (result.equals("")) {
                System.err.println("There is no such file in current directory!");

                try (FileWriter errorWriter = new FileWriter(DIR.getName() + "/error.log", StandardCharsets.UTF_8, true)) {
                    errorWriter.write("Invalid filename: " + line + System.lineSeparator());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                printFiles();
            } else {
                System.out.println(result);
            }
        } while (true);
    }

    public static void printFiles() {
        File[] files = DIR.listFiles();
        String canonicalPath;
        try {
            canonicalPath = DIR.getCanonicalPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("type \"exit\" to end program");
        System.out.println("Files in " + canonicalPath + ":");
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
