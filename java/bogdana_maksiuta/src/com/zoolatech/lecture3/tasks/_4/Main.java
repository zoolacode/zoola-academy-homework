package com.zoolatech.lecture3.tasks._4;

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
        Reporter csvReporter = new CsvReporter("Class Record",
                "This is the common base class ...",
                "Task3") {
        };
        csvReporter.generate();

        Reporter pdfReporter = new PdfReporter("Class ArrayList",
                "Resizable-array implementation...", "Task10");
        pdfReporter.generate();

        Reporter docReporter = new DocReporter("Keeping pets",
                "..., the most important of them...", "task10-2");
        docReporter.generate();

    }
}
