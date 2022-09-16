package com.zoolatech.lecture10.tasks;

import java.io.*;
import java.time.LocalDateTime;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    private String path;
    private Pattern pattern = Pattern.compile(".txt");

    public FileReader(String path) {
        this.path = path;
    }

    public void readFile(String name) {
        StringBuilder builder = new StringBuilder(path);
        File file = new File(builder.append(name).append(".txt").toString());

        if (isFileExist(file)) {
            try (InputStream stream = new FileInputStream(file)) {
                String result = new String(stream.readAllBytes());
                System.out.println(result);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean isFileExist(File file) {
        if (!file.exists()) {
            System.err.println("File '" + file.getName() + "' not found");
            writeLog(file.getName());
            return false;
        }
        return true;
    }

    private void writeLog(String file) {
        try (FileWriter fileWriter = new FileWriter(path + "error.log", true)) {
            fileWriter.write(file + " [" + LocalDateTime.now() + "]\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getFilesAsString() {
        String collect = Stream.of(new File(path).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .filter(name -> !name.endsWith("log"))
                .collect(Collectors.joining(", "));
        return pattern.matcher(collect).replaceAll("");
    }
}
