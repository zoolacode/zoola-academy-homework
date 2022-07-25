package com.zoolatech.lecture3.tasks._4;

public class PdfReporter extends Reporter {

    public PdfReporter(String headerData, String fileData, String fileName) {
        super(headerData, fileData, fileName);
    }

    @Override
    void generate() {
        openFile();
        System.out.println(".pdf");
        addHeaderData();
        System.out.println(".pdf in PDF format");
        addFileData();
        System.out.println(".pdf in PDF format");
        closeFile();
        System.out.println(".pdf");
    }
}
