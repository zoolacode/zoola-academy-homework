package com.zoolatech.lecture3.tasks._2;

abstract class Validator implements Validating {
    String fieldName;

    Validator(String fieldName) {
        this.fieldName = fieldName;
    }
}
