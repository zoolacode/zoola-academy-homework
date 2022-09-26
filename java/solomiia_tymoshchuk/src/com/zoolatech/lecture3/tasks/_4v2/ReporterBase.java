package com.zoolatech.lecture3.tasks._4v2;

/**
 * Did the second version for practising abstract classes use; and actually, as you showed analogue of use in lesson as example.
 */

abstract class ReporterBase {
    String headerData;
    String fileData;
    String fileName;

    public ReporterBase(String headerData, String fileData, String fileName) {
        this.headerData = headerData;
        this.fileData = fileData;
        this.fileName = fileName;
    }

    public void generate() {
        createFile();
        addHeaderData();
        addFileData();
    }

    abstract void createFile();

    abstract void addHeaderData();

    abstract void addFileData();


    public static void main(String[] args) {
        String fileName = "filee";
        String headerData = "importantData";
        String fileData = "Data";
        CsvReporter csvReporter = new CsvReporter(headerData, fileData, fileName);
        csvReporter.generate();
    }
}
