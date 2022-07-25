package com.zoolatech.lecture3.tasks._4;

public class CsvReporter extends Reporter {

    public CsvReporter(String headerData, String fileData, String fileName) {
        super(headerData, fileData, fileName);
    }

    @Override
    void generate() {
        openFile();
        System.out.println(".txt");
        addHeaderData();
        System.out.println(".txt in CSV format");
        addFileData();
        System.out.println(".txt in CSV format");
        closeFile();
        System.out.println(".txt");
    }
}
