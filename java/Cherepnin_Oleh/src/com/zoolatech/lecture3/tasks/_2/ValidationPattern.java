package com.zoolatech.lecture3.tasks._2;

import java.util.regex.Pattern;

public enum ValidationPattern {
    EMAIL("[a-z_0-9]{3,}@[a-z]{3,6}\\.[a-z]{2,4}"),
    NAME("[A-Z][a-z]+"),
    NUMBER("\\d{3}-\\d{3}-\\d{2}-\\d{2}");

    private Pattern pattern;

    ValidationPattern(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public Pattern getPattern() {
        return pattern;
    }
}
