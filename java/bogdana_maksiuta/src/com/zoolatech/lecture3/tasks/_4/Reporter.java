package com.zoolatech.lecture3.tasks._4;

import java.util.Scanner;

public abstract class Reporter {
    String headerData;
    String fileData;
    String fileName;

    public Reporter(String headerData, String fileData, String fileName) {
        this.headerData = headerData;
        this.fileData = fileData;
        this.fileName = fileName;
    }

    void generate() {
        System.out.println("\nWhat do you want? \nPress '1' for create a file \nPress '2' for add header data" +
                "\nPress '3' for add file data \nPress '4' for exit");

        Scanner scanner = new Scanner(System.in);
        int choiceNumber = scanner.nextInt();
        switch (choiceNumber) {
            case 1 -> {
                System.out.println("Create a  file : " + fileName);
                generate();
            }
            case 2 -> {
                System.out.println("Add header data : " + headerData);
                int choiceToSave = 0;
                while (choiceToSave <= 0 || choiceToSave > 2) {
                    System.out.println("\nSave changes to document " + fileName + " before closing?" +
                            "\nPress '1' - YES \nPress '2' - NO");
                    choiceToSave = scanner.nextInt();
                    switch (choiceToSave) {
                        case 1 -> System.out.println("The last changes are saved.");
                        case 2 -> System.out.println("The last changes are lost.");
                        case 3 -> System.out.println("Invalid value. Try again");
                    }
                }
                generate();
            }
            case 3 -> {
                System.out.println("Add file data : " + fileData);

                int choiceToSave = 0;
                while (choiceToSave <= 0 || choiceToSave > 2) {
                    System.out.println("\nSave changes to document " + fileName + " before closing?" +
                            "\nPress '1' - YES \nPress '2' - NO");
                    choiceToSave = scanner.nextInt();
                    switch (choiceToSave) {
                        case 1 -> System.out.println("The last changes are saved.");
                        case 2 -> System.out.println("The last changes are lost.");
                        case 3 -> System.out.println("Invalid value. Try again");
                    }
                }
                generate();
            }
            case 4 -> {
                System.out.println("Bye");
            }

            default -> {
                System.out.println("Invalid number. Try again");
                generate();
            }
        }
    }
}
