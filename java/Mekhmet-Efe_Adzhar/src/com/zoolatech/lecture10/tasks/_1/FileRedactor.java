package com.zoolatech.lecture10.tasks._1;

import java.io.*;
import java.util.Date;

final class FileRedactor {

    public static void showFiles(File file) throws NoFileException {
        File[] files = file.listFiles();
        int counter = 0;
        for (File value : files) {
            if (value.isFile()) {
                System.out.println("File number " + ++counter + " : " + value.getName());
            } else if (value.isDirectory()) {
                System.out.println("Directory: " + value.getName());
            } else {
                throw new NoFileException();
            }
        }
    }

    public static void generateFiles(String string, File file) throws IOException, NoFileException {
        switch (string) {
            case "names":
                FileInputStream fileInputStream = new FileInputStream(file + "/names.txt");
                String result = new String(fileInputStream.readAllBytes());
                System.out.println(result);
                break;
            case "positions":
                fileInputStream = new FileInputStream(file + "/positions.txt");
                result = new String(fileInputStream.readAllBytes());
                System.out.println(result);
                break;
            case "surnames":
                fileInputStream = new FileInputStream(file + "/surnames.txt");
                result = new String(fileInputStream.readAllBytes());
                System.out.println(result);
                System.out.println();
                break;
            default:
                //creating error.log file and writing down incorrect scanner input(file name)
                errorLog(file, string);
        }
    }

    private static void errorLog(File file, String string) throws IOException, NoFileException {
        int counter = 0;
        try (FileWriter fileWriter = new FileWriter(file + "/error.log",true)){
            fileWriter.write(string + " invalid input number: "+ new Date() + "\n");
        }
        System.out.println("Written invalid filename to error.log\n");
        System.out.println("1. Start\n2. Exit");
    }
}