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

/**
 * Given a directory called db with 3 files:
 * names (Ex. of content Alex, John, Maria)
 * surnames (Scott, Fung, Chan)
 * positions (Delivery Manager, Senior Java Dev, Product Manager).
 * When user starts app it can see in terminal list of files without content.
 * User can type file name like "names" and see content of the file on terminal.
 * If user type invalid filename app should write message to err stream,
 * draw file names again and write invalid filename to a new file called
 * "error.log" (ideally data should be appended).
 */

public class Task1 {
    public static void main(String[] args) throws IOException {
        File db = new File("/home/x/IdeaProjects/zoola-academy-homework/java/mykola-melnyk/src/com/zoolatech/lecture9/tasks/_1/db/");

        FileBrowser myDir = new FileBrowser(db);
        myDir.loopOpen();

    }
}
