package com.zoolatech.lecture9.tasks._1.examples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Scratch4 {
    // Demo 4 write/read Serializable object
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("test_obj3.json");
             ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream)) {
            Student student = new Student(1, "test");
            outputStream.writeObject(student);
        }

        try (FileInputStream fileInputStream = new FileInputStream("test_obj3.json");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Student readObject = (Student) objectInputStream.readObject();
            System.out.println(readObject.name);
        }
    }

    public static class Student implements Serializable {
        public int id;
        public String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}