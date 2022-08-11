package com.zoolatech.lecture3.tasks._2;

abstract class Validator implements Validatable {
    String fieldName;

    Validator(String fieldName) {
        this.fieldName = fieldName;
    }
}
