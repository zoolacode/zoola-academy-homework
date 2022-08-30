package com.zoolatech.lecture3.tasks._4;

public non-sealed class CsvReporter extends Reporter {
    CsvReporter(String headerData, String fileData, String fileName) {
        super(headerData, fileData, fileName);
    }

    @Override
    void createFile() {
        super.createFile();
        System.out.println(".csv created!");
    }

    @Override
    void addHeaderData() {
        super.addHeaderData();
        System.out.println("CSV format...");
    }

    @Override
    void closeFile() {
        super.closeFile();
        System.out.println("CSV format!");
    }
}
