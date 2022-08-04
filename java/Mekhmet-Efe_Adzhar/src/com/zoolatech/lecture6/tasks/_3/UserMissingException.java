package com.zoolatech.lecture6.tasks._3;

class UserMissingException extends Exception {
    public UserMissingException(String errorMessage) {
        super(errorMessage);
    }

    public UserMissingException() {
        System.out.println("Error, User not found:");
    }
}