package com.zoolatech.lecture9.tasks.examples;

import java.io.FileInputStream;
import java.io.IOException;

class Scratch3 {
    // Demo 2 FileInputStream
    public static void main(String[] args) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("/home/x/IdeaProjects/zoola-academy-homework/java/mykola-melnyk/src/com/zoolatech/lecture9/tasks/_1/db/positions")) {
            String result = new String(fileInputStream.readAllBytes());
            System.out.println(result);
        }
    }


}