package com.zoolatech.lecture9.tasks.examples;

import java.io.File;

public class Browser {
    public static void main(String[] args)
    {

        // try-catch block to handle exceptions
        try {

            // Create a file object
            File f = new File("/home/x/IdeaProjects/zoola-academy-homework/java/mykola-melnyk/src/com/zoolatech/lecture9/tasks/_1/db/");

            // Get all the names of the files present
            // in the given directory
            File[] files = f.listFiles();

            System.out.println("Files are:");

            // Display the names of the files
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].getName());
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

