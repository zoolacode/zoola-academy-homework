package com.zoolatech.lecture10.tasks._1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String path = "java/Anton-Kozyk/src/com/zoolatech/lecture10/tasks/_1/employeeData/";
        File directoryPath = new File(path);
        FileProcessor fileProcessor = new FileProcessor(directoryPath);
        Scanner scanner = new Scanner(System.in);

        if (directoryPath.exists() && directoryPath.isDirectory()) {
            String fileName;
            do {
                fileProcessor.printDirectoryContent();
                System.out.print("\nIf u wanna to see content of any file just type it's name: ");
                fileName = scanner.nextLine();
                fileProcessor.printFileContent(new File(path + fileName));
                Thread.sleep(100);
            } while (!new File(path + fileName).exists());
        } else {
            System.err.println("Wrong directory!");
        }
    }
}
