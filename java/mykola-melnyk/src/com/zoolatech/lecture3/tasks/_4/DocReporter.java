package com.zoolatech.lecture3.tasks._4;

public class DocReporter extends Reporter {
    DocReporter(String headerData, String fileData, String fileName){
        super(headerData, fileData, fileName);
    }

    @Override
    public void addHeaderData() {
        System.out.printf("Adding %s in DOC format. \n", this.getHeaderData());
    }

    @Override
    public void addFileData() {
        System.out.printf("Adding %s in DOC format. \n", this.getFileData());
    }

}
