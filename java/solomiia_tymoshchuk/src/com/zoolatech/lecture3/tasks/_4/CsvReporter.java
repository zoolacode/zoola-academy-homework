package com.zoolatech.lecture3.tasks._4;

public class CsvReporter extends ReporterBase {

    public CsvReporter(String headerData, String fileData, String fileName) {
        super(headerData, fileData, fileName);
    }

    void generate() {
        String fileExtension = ".csv";
        generateFile(fileExtension);
    }

}
