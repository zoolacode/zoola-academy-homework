package com.zoolatech.lecture3.tasks._4;

public abstract sealed class Reporter permits CsvReporter, PdfReporter, DocReporter{
    String headerData;
    String fileData;
    String fileName;

    Reporter(String headerData, String fileData, String fileName) {
        this.headerData = headerData;
        this.fileData = fileData;
        this.fileName = fileName;
    }

    public void generate() {
        createFile();
        addHeaderData();
        addFileData();
        closeFile();
    }

    public abstract void createFile();
    public abstract void addHeaderData();
    public abstract void addFileData();
    public abstract void closeFile();
}
