package com.zoolatech.lecture10.tasks._1;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

final class FileRedactor {

    private final File file;

    public FileRedactor(File file) {
        this.file = file;
    }

    public void showFiles() {
        File[] files = file.listFiles();
        int counter = 0;

        assert files != null;
        for (File value : files) {
            if (value.isFile()) {
                System.out.println("File number " + ++counter + " : " + value.getName());
            }
        }
    }

    public boolean generateFiles(String fileName) throws IOException {
        File[] files = file.listFiles();
        assert files != null;
        return Arrays.stream(files)
                .map(file1 -> file1.getName().equals(fileName) && file1.exists())
                .findFirst()
                .orElse(errorLog(fileName));
    }

    private boolean errorLog(String fileName) throws IOException {
        final LocalDate localDate = LocalDate.now();
        final LocalDateTime localDateTime = LocalDateTime.now();
        try (FileWriter fileWriter = new FileWriter(file + "/error.log", true)) {
            fileWriter.write(fileName + " invalid input number: " + localDate + ", time: " + localDateTime + "\n");
        }
        System.out.println("No file with such name");
        System.out.println("Written invalid filename to error.log");
        System.out.println("1. Start\n2. Exit");
        return false;
    }
}