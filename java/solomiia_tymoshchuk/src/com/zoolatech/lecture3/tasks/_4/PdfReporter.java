package com.zoolatech.lecture3.tasks._4;

public class PdfReporter extends ReporterBase{
    public PdfReporter(String headerData, String fileData, String fileName) {
        super(headerData, fileData, fileName);
    }

    void generate() {
        String fileExtension = ".pdf";
        generateFile(fileExtension);
    }

}
