package com.zoolatech.lecture3.tasks._4;

public non-sealed class DocReporter extends Reporter {
    DocReporter(String headerData, String fileData, String fileName) {
        super(headerData, fileData, fileName);
    }

    @Override
    void createFile() {
        super.createFile();
        System.out.println(".doc created!");
    }

    @Override
    void addHeaderData() {
        super.addHeaderData();
        System.out.println("DOC format...");
    }

    @Override
    void closeFile() {
        super.closeFile();
        System.out.println("DOC format!");
    }
}
