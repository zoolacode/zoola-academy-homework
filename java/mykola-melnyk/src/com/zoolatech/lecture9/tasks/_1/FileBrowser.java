package com.zoolatech.lecture9.tasks._1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FileBrowser {
    File dir;

    public FileBrowser(File dir) {
        this.dir = dir;
    }

    public void showAndOpen() {

        File[] files = dir.listFiles(); // show contents
        System.out.println("Files list:");
        for (int i = 0; i < Objects.requireNonNull(files).length; i++) {
            System.out.println(files[i].getName());
        }

        System.out.println("Choose a file to open:"); // opening a file
        String pathWithName;
        try {                                           // reading file name
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));
            pathWithName = dir.getPath() + "/" + br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(pathWithName);  // printing file to console
            String result = new String(fileInputStream.readAllBytes());
            System.out.println(result);

        } catch (IOException e) {
            String error = "File " + pathWithName + " not found.";
            System.err.println(error);  // outputting error to console
            try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("/home/x/IdeaProjects/zoola-academy-homework/java/mykola-melnyk/src/com/zoolatech/lecture9/tasks/_1/error.log"))) {  // outputting error to file
                outputStream.write(error.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    public void loopOpen() {
        while (true) this.showAndOpen();
    }


}
