package com.zoolatech.lecture10.tasks._1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileReader {
    private File directory;

    public FileReader(File directory) {
        this.directory = directory;
    }

    public void directoryContent() {
        System.out.println("Directory content:");
        String[] list = directory.list();
        for (String file : list) {
            if (!file.equals("error.log")) {
                System.out.println("-" + file);
            }
        }
    }

    public void fileContent(File file) throws IOException {
        if (!file.exists()) {
            System.err.println("File '" + file.getName() + "' not found. Try again...\n");
            try (FileWriter fileWriter = new FileWriter(directory.getPath() + "/error.log", true)) {
                fileWriter.write(file.getName() + " [" + new Date() + "]\n");
            }
            return;
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            System.out.println(new String(fis.readAllBytes()));
        }
    }
}
