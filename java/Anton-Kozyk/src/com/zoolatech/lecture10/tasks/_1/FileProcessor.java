package com.zoolatech.lecture10.tasks._1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileProcessor {
    private File directory;

    public FileProcessor(File directory) {
        this.directory = directory;
    }

    public void printDirectoryContent() {
        System.out.println("Directory content:");
        String[] list = directory.list();
        for (String file : list) {
            if (!file.equals("error.log")) {
                System.out.println("-" + file);
            }
        }
    }

    public void printFileContent(File file) throws IOException {
        if (!file.exists()) {
            System.err.println("File '" + file.getName() + "' not found. Try again...\n");
            try (FileWriter fileWriter = new FileWriter(directory.getPath() + "/error.log", true)) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                fileWriter.write(file.getName() + " [" + LocalDateTime.now().format(format) + "]\n");
            }
            return;
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            System.out.println(new String(fis.readAllBytes()));
        }
    }
}
