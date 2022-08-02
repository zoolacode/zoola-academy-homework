package com.zoolatech.lecture3.tasks._4;

public class DocReporter extends Reporter {

    public DocReporter(String headerData, String fileData, String fileName) {
        super(headerData, fileData, fileName);
    }

    void generate() {
        System.out.println(createNewFile() + ".doc");
        System.out.println((addHeaderData() + ".doc"));
        System.out.println(addFileData() + "DOC format");
        System.out.println(close() + ".doc");
    }
}

