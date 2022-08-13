package com.zoolatech.lecture10.tasks._1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

final class Menu {
    public static void menu() throws IOException, NoFileException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello and welcome to DB. Type a file name you need:)");
        File file = new File("java/Mekhmet-Efe_Adzhar/src/com/zoolatech/lecture10/tasks/_1/db");
        FileRedactor.showFiles(file);
        FileRedactor.generateFiles(scanner.nextLine(), file);
    }
}