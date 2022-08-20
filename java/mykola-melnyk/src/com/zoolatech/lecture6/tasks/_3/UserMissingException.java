package com.zoolatech.lecture6.tasks._3;

public class UserMissingException extends Exception{
    private String missingID;

    public UserMissingException(String id) {
        missingID = id;
    }
    public String getMissingID() {
        return missingID;
    }
}
