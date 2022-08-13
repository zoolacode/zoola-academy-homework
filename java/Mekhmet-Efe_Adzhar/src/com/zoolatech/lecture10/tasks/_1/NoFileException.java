package com.zoolatech.lecture10.tasks._1;

final class NoFileException extends Error {
    public NoFileException() {
        super("File error: No such file");
    }
}