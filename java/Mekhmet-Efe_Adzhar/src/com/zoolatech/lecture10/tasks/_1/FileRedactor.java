package com.zoolatech.lecture10.tasks._1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

final class FileRedactor {

    private final File file;

    public FileRedactor(File file) {
        this.file = file;
    }

    public void showAllAvailableFiles() {
        File[] files = file.listFiles();
        int counter = 0;

        if (files != null) {
            for (File value : files) {
                if (value.isFile()) {
                    System.out.println("File number " + ++counter + " : " + value.getName());
                }
            }
        } else {
            System.err.println("No files");
        }
    }

    public String showFileContent(String fileName) throws IOException {
        File[] files = file.listFiles();

        if (files == null) {
            System.err.println("File is empty");
        } else {
            for (File fileInFiles : files) {
                if (fileInFiles.exists() && fileInFiles.getName().equals(fileName)) {
                    try (FileInputStream fileInputStream = new FileInputStream(file + "/" + fileName)) {
                        return new String(fileInputStream.readAllBytes());
                    }
                }
            }
        }
         logError(fileName);
        return "1. Start\n2. Exit";
    }

    private void logError(String fileName) throws IOException {
        final LocalDate localDate = LocalDate.now();
        final LocalDateTime localDateTime = LocalDateTime.now();
        try (FileWriter fileWriter = new FileWriter(file + "/error.log", true)) {
            fileWriter.write(fileName + " invalid input was made: " + localDate + ", time: " + localDateTime + "\n");
        }
        System.err.println("No file with such name");
        System.err.println("Written invalid filename to error.log");
    }
}