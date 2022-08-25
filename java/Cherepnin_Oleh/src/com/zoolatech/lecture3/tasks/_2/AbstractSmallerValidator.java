package com.zoolatech.lecture3.tasks._2;

public abstract class AbstractSmallerValidator implements SmallerValidator {
    protected String fieldName;

    public AbstractSmallerValidator(String fieldName) {
        this.fieldName = fieldName;
    }

    protected void printMassage() {
        System.out.println("Field '" + fieldName + "' is invalid");
    }
}
