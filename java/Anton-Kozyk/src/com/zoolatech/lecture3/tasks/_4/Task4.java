package com.zoolatech.lecture3.tasks._4;

/**
 * Create three classes CsvReporter, PdfReporter and DocReporter which are able to
 * create files with tabular data in CSV, PDF and DOC formats accordingly. Each
 * class needs to accept three strings during an object construction (header data,
 * file data and file name) and have a method called generate. The method needs to
 * create a new file, add header data in an appropriate format (CSV, PDF, DOC), add
 * file data in an appropriate format and close a file. You don’t need to work with
 * files directly: to complete the task you can just print statements like “Opening a
 * file test.txt” or “Adding file details in CSV format” for each action.
 */

public class Task4 {
    public static void main(String[] args) {
        Reporter pdfFile = new PdfReporter("Colors",
                "1 -red, 2 - blue, 3 - green",
                "Colors");

        pdfFile.generate();
        System.out.println();


        Reporter docFile = new DocReporter("Seasons",
                "Winter, Spring, Summer, Autumn",
                "Seasons");

        docFile.generate();
        System.out.println();


        Reporter csvFile = new CsvReporter("Test header",
                "test1, test2, test3, test4",
                "justTest");

        csvFile.generate();
        System.out.println();


    }
}
