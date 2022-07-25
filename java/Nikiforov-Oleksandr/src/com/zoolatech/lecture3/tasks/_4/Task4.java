package com.zoolatech.lecture3.tasks._4;

import java.util.ArrayList;

/**
 * Create three classes CsvReporter, PdfReporter and DocReporter which are able to create files with tabular
 * data in CSV, PDF and DOC formats accordingly. Each class needs to accept three strings during an object
 * construction (header data, file data and file name) and have a method called generate. The method needs
 * to create a new file, add header data in an appropriate format (CSV, PDF, DOC), add file data in
 * an appropriate format and close a file. You don’t need to work with files directly: to complete the task
 * you can just print statements like “Opening a file test.txt” or “Adding file details in CSV format” for each action.
 * Try to minimize duplicated code between classes (note, that in a real world multiple statements
 * might be needed to perform these tasks).
 */

public class Task4 {
    public static void main(String[] args) {
        ArrayList<Reporter> reporters = new ArrayList<>();
        CsvReporter csvReporter = new CsvReporter("Zapovit", "Yak umru to pohovaite mene na mogili", "T.G.Shevchenko");
        reporters.add(csvReporter);
        DocReporter docReporter = new DocReporter("Moluys i viruy", "Moluys i viruy, viter grae i piano vie navkrygu", "M.F.Rulskii");
        reporters.add(docReporter);
        PdfReporter pdfReporter = new PdfReporter("Contra spem spero", "Bez nadii spodivaus", "LesyaUkrainka");
        reporters.add(pdfReporter);
        for (Reporter reporter : reporters) {
            reporter.generate();
            System.out.println("\n");
        }
    }
}
