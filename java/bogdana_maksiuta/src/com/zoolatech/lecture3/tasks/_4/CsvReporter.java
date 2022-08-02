package com.zoolatech.lecture3.tasks._4;

public class CsvReporter extends Reporter {

    public CsvReporter(String headerData, String fileData, String fileName) {
        super(headerData, fileData, fileName);
    }

    void generate() {
        System.out.println(createNewFile() + ".csv");
        System.out.println((addHeaderData() + ".csv"));
        System.out.println(addFileData() + "CSV format");
        System.out.println(close() + ".csv");    }
}
