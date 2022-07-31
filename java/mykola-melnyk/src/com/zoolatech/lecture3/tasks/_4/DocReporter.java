package com.zoolatech.lecture3.tasks._4;

public class DocReporter extends Reporter {
    DocReporter(String headerData, String fileData, String fileName){
        super(headerData, fileData, fileName);
    };

    @Override
    public void createFile() {
        System.out.printf("Creating a file with name %s. \n", fileName);
    }

    @Override
    public void addHeaderData() {
        System.out.printf("Adding %s in DOC format. \n", headerData);
    }

    @Override
    public void addFileData() {
        System.out.printf("Adding %s in DOC format. \n", fileData);
    }

    @Override
    public void closeFile() {
        System.out.printf("Closing a file with name %s. \n", fileName);
    }
}
