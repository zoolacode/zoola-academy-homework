package com.zoolatech.lecture3.tasks._4;

public non-sealed class CsvReporter extends Reporter {
    public CsvReporter(String csvHeaderData, String csvFileData, String csvFileName) {
        super(csvHeaderData, csvFileData, csvFileName);
    }

    @Override
    public void createFile() {
        System.out.println("Create CSV file: " + fileName);
    }

    @Override
    public void addHeaderData() {
        System.out.println("Add CSV header data: " + headerData);
    }

    @Override
    public void addFileData() {
        System.out.println("Add CSV file data: " + fileData);
    }

    @Override
    public void closeFile() {
        System.out.println("Close CSV file: " + fileName);
    }
}
