package com.zoolatech.lecture3.tasks._4;

public abstract class Reporter {
    String headerData;
    String fileData;
    String fileName;

    public Reporter(String headerData, String fileData, String fileName) {
        this.headerData = headerData;
        this.fileData = fileData;
        this.fileName = fileName;
    }

    void generate() {
        createNewFile();
        addHeaderData();
        addFileData();
        close();
    }
    String createNewFile () {
        return "\nCreate a new file: " + fileName;
    }

    String addHeaderData () {
        return "Add header: \"" + headerData + "\" to file: " + fileName;
    }

    String addFileData () {
        return "Add file details: \"" + fileData + "\" in ";
    }
    String close () {
        return "Close file " + fileName;
    }
}
