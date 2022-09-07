package com.zoolatech.lecture9.tasks._1.examples;

import java.io.FileInputStream;
import java.io.IOException;

class Scratch3 {
    // Demo 2 FileInputStream
    public static void main(String[] args) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("/Users/ogorbov/Library/Application Support/JetBrains/IntelliJIdea2022.2/scratches/test.json")) {
            String result = new String(fileInputStream.readAllBytes());
            System.out.println(result);
        }
    }


}