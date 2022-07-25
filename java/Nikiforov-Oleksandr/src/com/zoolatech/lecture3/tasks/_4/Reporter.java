package com.zoolatech.lecture3.tasks._4;

public abstract class Reporter {
    protected String headerData;
    protected String fileData;
    protected String fileName;

    public Reporter(String headerData, String fileData, String fileName) {
        this.headerData = headerData;
        this.fileData = fileData;
        this.fileName = fileName;
    }

    abstract void generate();

    protected void openFile() {
        System.out.print("Opening file " + fileName);
    }

    protected void addHeaderData() {
        System.out.print("Added header " + headerData + " to " + fileName);
    }

    protected void addFileData() {
        System.out.print("Added file data " + fileData + " to " + fileName);
    }

    protected void closeFile() {
        System.out.print("Closing file " + fileName);
    }

}
