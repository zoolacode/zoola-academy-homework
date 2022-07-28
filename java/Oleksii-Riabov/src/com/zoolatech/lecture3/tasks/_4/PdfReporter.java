package com.zoolatech.lecture3.tasks._4;

public non-sealed class PdfReporter extends Reporter {
    public PdfReporter(String pdfHeaderData, String pdfFileData, String pdfFileName) {
        super(pdfHeaderData, pdfFileData, pdfFileName);
    }

    @Override
    public void createFile() {
        System.out.println("Create PDF file: " + fileName);
    }

    @Override
    public void addHeaderData() {
        System.out.println("Add PDF header data: " + headerData);
    }

    @Override
    public void addFileData() {
        System.out.println("Add PDF file data: " + fileData);
    }

    @Override
    public void closeFile() {
        System.out.println("Close PDF file: " + fileName);
    }
}
