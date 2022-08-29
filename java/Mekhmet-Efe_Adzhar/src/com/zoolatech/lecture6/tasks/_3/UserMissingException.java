package com.zoolatech.lecture6.tasks._3;

class UserMissingException extends Exception {
    public UserMissingException(String id) {
        super("Error, User not found by id: " + id);
    }
}