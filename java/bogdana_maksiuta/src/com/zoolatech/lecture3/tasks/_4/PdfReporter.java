package com.zoolatech.lecture3.tasks._4;

public class PdfReporter extends Reporter {

    public PdfReporter(String headerData, String fileData, String fileName) {
        super(headerData, fileData, fileName);
    }

    void generate() {
        System.out.println(createNewFile() + ".pdf");
        System.out.println((addHeaderData() + ".pdf"));
        System.out.println(addFileData() + "PDF format");
        System.out.println(close() + ".pdf");
    }
}
