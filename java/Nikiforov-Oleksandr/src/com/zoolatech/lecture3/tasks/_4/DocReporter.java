package com.zoolatech.lecture3.tasks._4;

public class DocReporter extends Reporter {

    public DocReporter(String headerData, String fileData, String fileName) {
        super(headerData, fileData, fileName);
    }

    @Override
    void generate() {
        openFile();
        System.out.println(".docx");
        addHeaderData();
        System.out.println(".docx in DOC format");
        addFileData();
        System.out.println(".docx in DOC format");
        closeFile();
        System.out.println(".docx");
    }
}
