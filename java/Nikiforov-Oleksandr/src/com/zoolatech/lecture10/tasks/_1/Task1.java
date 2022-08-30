package com.zoolatech.lecture10.tasks._1;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


public class Task1 {
    public static void main(String[] args) throws IOException {
        String database = "src/com/zoolatech/lecture10/tasks/_1/db/";
        File dir = new File(database);
        String errorFile = "error.log";

        ArrayList<String> files = new ArrayList<>();
        if (dir.isDirectory()) {
            System.out.println("Type the file name you want to view, or type 'exit' to close the app. Files you can check:");
            for (File item : dir.listFiles()) {
                if (item.isFile()) {
                    if (!item.getName().equals(errorFile)) {
                        System.out.println(item.getName());
                        files.add(item.getName());
                    }
                }
            }
        }

        Scanner sc = new Scanner(System.in);
        String inputer = sc.next();

        while (!inputer.equals("exit")) {
            if (files.contains(inputer)) {
                String currentFile = database + inputer;
                try (FileInputStream fileInputStream = new FileInputStream(currentFile)) {
                    String result = new String(fileInputStream.readAllBytes());
                    System.out.println(result);
                }
            } else {
                try (FileWriter fileWriter = new FileWriter(database+errorFile, true)) {
                    String errorMessage = "File " + inputer + " does not exist!";
                    System.out.println(errorMessage);
                    fileWriter.write(errorMessage);
                    fileWriter.write("\n");
                }
            }
            inputer = sc.next();
        }
    }

}