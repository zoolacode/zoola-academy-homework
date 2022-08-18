package com.zoolatech.lecture3.tasks._4;

public non-sealed class PdfReporter extends Reporter {
    PdfReporter(String headerData, String fileData, String fileName) {
        super(headerData, fileData, fileName);
    }

    @Override
    void createFile() {
        super.createFile();
        System.out.println(".pdf created!");
    }

    @Override
    void addHeaderData() {
        super.addHeaderData();
        System.out.println("PDF format...");
    }

    @Override
    void closeFile() {
        super.closeFile();
        System.out.println("PDF format!");
    }
}
