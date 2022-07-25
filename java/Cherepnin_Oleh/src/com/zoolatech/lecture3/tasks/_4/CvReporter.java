package com.zoolatech.lecture3.tasks._4;

public class CvReporter extends AbstractReporter {
    public CvReporter(String header, String data, String name) {
        super(header, data, name);
    }

    public CvReporter(AbstractReporter reporter) {
        super(reporter);
    }

    @Override
    protected void convert() {
        System.out.println("File successfully convert to Cv format");
    }
}
