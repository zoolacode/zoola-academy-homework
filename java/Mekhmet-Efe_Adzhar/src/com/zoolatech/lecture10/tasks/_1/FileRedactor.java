package com.zoolatech.lecture10.tasks._1;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

final class FileRedactor {

    public static void showFiles(File file) throws FileNotFoundException {
        File[] files = file.listFiles();
        int counter = 0;

        assert files != null;
        for (File value : files) {
            if (value.isFile()) {
                System.out.println("File number " + ++counter + " : " + value.getName());
            } else if (value.isDirectory()) {
                System.out.println("Directory: " + value.getName());
            } else {
                throw new FileNotFoundException();
            }
        }
    }

    public static void generateFiles(String fileName, File filePath) throws IOException {

        switch (fileName) {
            case "names":
                FileInputStream fileInputStream = new FileInputStream(filePath + "/names.txt");
                String result = new String(fileInputStream.readAllBytes());
                System.out.println(result);
                break;
            case "positions":
                fileInputStream = new FileInputStream(filePath + "/positions.txt");
                result = new String(fileInputStream.readAllBytes());
                System.out.println(result);
                break;
            case "surnames":
                fileInputStream = new FileInputStream(filePath + "/surnames.txt");
                result = new String(fileInputStream.readAllBytes());
                System.out.println(result);
                System.out.println();
                break;
            default:
                //creating error.log filePath and writing down incorrect scanner input(filePath name)
                errorLog(filePath, fileName);
        }
    }

    private static void errorLog(File file, String string) throws IOException {
        final LocalDate localDate = LocalDate.now();
        final LocalDateTime localDateTime = LocalDateTime.now();
        try (FileWriter fileWriter = new FileWriter(file + "/error.log", true)) {
            fileWriter.write(string + " invalid input number: " + localDate + " " + localDateTime + "\n");
        }
        System.out.println("No file with such name\n");
        System.out.println("Written invalid filename to error.log\n");
        System.out.println("1. Start\n2. Exit");
    }
}