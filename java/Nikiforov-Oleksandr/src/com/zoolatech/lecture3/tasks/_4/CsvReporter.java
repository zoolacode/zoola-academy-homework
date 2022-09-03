package com.zoolatech.lecture3.tasks._4;

public class CsvReporter extends Reporter {
    private static final String FORMAT = " in CSV format";
    public CsvReporter(String headerData, String fileData, String fileName) {
        super(headerData, fileData, fileName+".txt");
    }
    @Override
    public void addHeaderData(){
        super.addHeaderData();
        System.out.println(FORMAT);
    }

    public void addFileData(){
        super.addFileData();
        System.out.println(FORMAT);
    }
}
