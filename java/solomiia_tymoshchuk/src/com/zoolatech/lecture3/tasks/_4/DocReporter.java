package com.zoolatech.lecture3.tasks._4;

public class DocReporter extends ReporterBase {

    public DocReporter(String headerData, String fileData, String fileName) {
        super(headerData, fileData, fileName);
    }

    void generate() {
        String fileExtension = ".csv";
        generateFile(fileExtension);
    }
}
