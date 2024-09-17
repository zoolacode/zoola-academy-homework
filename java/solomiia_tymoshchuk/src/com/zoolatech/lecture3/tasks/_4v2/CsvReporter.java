package com.zoolatech.lecture3.tasks._4v2;

public class CsvReporter extends ReporterBase {

    public CsvReporter(String headerData, String fileData, String fileName) {
        super(headerData, fileData, fileName);
    }

    String fileExtension = ".csv";

    @Override
    void createFile() {
        System.out.printf("Create %s%s file\n", fileName, fileExtension);
    }

    @Override
    void addHeaderData() {
        System.out.printf("Add %s to %s%s file\n", headerData, fileName, fileExtension);
    }

    @Override
    void addFileData() {
        System.out.printf("Add %s to %s%s file\n", fileData, fileName, fileExtension);
    }
}
