package com.zoolatech.lecture3.tasks._4;

public class ReporterBase {
    static String headerData;
    static String fileData;
    static String fileName;

    public ReporterBase(String headerData, String fileData, String fileName) {
        ReporterBase.headerData = headerData;
        ReporterBase.fileData = fileData;
        ReporterBase.fileName = fileName;
    }

    static void generateFile(String fileExtension) {
        System.out.println("Creating file named" + fileName + fileExtension);
        System.out.println("Adding" + fileData);
        System.out.println("Adding" + headerData);
    }

    public static void main(String[] args) {
        String fileName = "filee";
        String headerData = "importantData";
        String fileData = "Data";
        CsvReporter csvReporter = new CsvReporter(headerData, fileData, fileName);
        csvReporter.generate();
    }
}
