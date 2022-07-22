package com.zoolatech.lecture3.tasks._4;

import java.util.Scanner;

/**
 *     4 Create three classes CsvReporter, PdfReporter and DocReporter which are able to create files
 *     with tabular data in CSV, PDF and DOC formats accordingly. Each class needs to accept three strings
 *     during an object construction (header data, file data and file name) and have a method called generate.
 *     The method needs to create a new file, add header data in an appropriate format (CSV, PDF, DOC),
 *     add file data in an appropriate format and close a file. You don’t need to work with files directly:
 *     to complete the task you can just print statements like “Opening a file test.txt” or
 *     “Adding file details in CSV format” for each action. Try to minimize duplicated code between classes
 *     (note, that in a real world multiple statements might be needed to perform these tasks).
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice <= 0 || choice > 3) {
            System.out.println("What file do you want to create? \nPress \"1\" for - CSV file \nPress \"2\" " +
                    "for - PDF file \nPress \"3\" for - DOC file");

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    CsvReporter csvReporter = new CsvReporter("Class Record",
                            "This is the common base class of all Java language record classes.",
                            "Task3");
                    csvReporter.generate();
                }

                case 2 -> {
                    PdfReporter pdfReporter = new PdfReporter("Class ArrayList",
                            "Resizable-array implementation of the List interface.", "Task10");
                    pdfReporter.generate();
                }
                case 3 -> {
                    DocReporter docReporter = new DocReporter("Keeping pets is good for children",
                            "..., the most important of them is the favourable effects it has " +
                                    "on children's psychology and growth.", "task10-2");
                    docReporter.generate();
                }
                default -> System.out.println("Invalid number. Try again");
            }
        }
    }
}
