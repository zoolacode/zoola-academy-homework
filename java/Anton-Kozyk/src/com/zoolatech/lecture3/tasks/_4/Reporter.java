package com.zoolatech.lecture3.tasks._4;

public sealed abstract class Reporter permits CsvReporter, PdfReporter, DocReporter {
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

    void createFile() {
        System.out.print("File " + fileName);
    }

    void addHeaderData() {
        System.out.print("Adding \"" + headerData + "\" as a header data in ");
    }

    void addFileData() {
        System.out.println("Adding \"" + fileData + "\" as a file data to file");
    }

    void closeFile() {
        System.out.print("The file was successfully created and all data were saved in ");
    }
}
