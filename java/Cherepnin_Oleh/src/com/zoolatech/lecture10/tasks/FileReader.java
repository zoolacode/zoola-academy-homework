package com.zoolatech.lecture10.tasks;

import java.io.*;
import java.util.Date;

public class FileReader {
    private String path;

    public FileReader(String path) {
        this.path = path;
    }

    public void readFile(String name) {
        StringBuilder builder = new StringBuilder(path);
        File file = new File(builder.append(name).append(".txt").toString());

        if (checkFile(file)) {
            try (InputStream stream = new FileInputStream(file)) {
                String result = new String(stream.readAllBytes());
                System.out.println(result);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean checkFile(File file) {
        if (!file.exists()) {
            System.err.println("File '" + file.getName() + "' not found");
            writeLog(file.getName());
            return false;
        }
        return true;
    }

    private void writeLog(String file) {
        try (FileWriter fileWriter = new FileWriter(path + "error.log", true)) {
            fileWriter.write(file + " [" + new Date() + "]\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
