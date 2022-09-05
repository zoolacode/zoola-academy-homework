package com.zoolatech.lecture3.tasks._4;

public non-sealed class DocReporter extends Reporter {
    public DocReporter(String docHeaderData, String docFileData, String docFileName) {
        super(docHeaderData, docFileData, docFileName);
    }

    @Override
    public void createFile() {
        System.out.println("Create DOC file: " + fileName);
    }

    @Override
    public void addHeaderData() {
        System.out.println("Add DOC header data: " + headerData);
    }

    @Override
    public void addFileData() {
        System.out.println("Add DOC file data: " + fileData);
    }

    @Override
    public void closeFile() {
        System.out.println("Close DOC file: " + fileName);
    }
}
