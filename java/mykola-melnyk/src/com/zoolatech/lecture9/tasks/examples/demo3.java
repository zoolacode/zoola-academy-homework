package com.zoolatech.lecture9.tasks.examples;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

class Scratch5 {
    public static void main(String[] args) throws IOException {
        String source = "test text2";
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("/home/x/IdeaProjects/zoola-academy-homework/java/mykola-melnyk/src/com/zoolatech/lecture9/tasks/_1/test_demo3.json"))) {
            outputStream.write(source.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        }
    }
}