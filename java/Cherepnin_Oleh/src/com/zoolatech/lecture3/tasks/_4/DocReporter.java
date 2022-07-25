package com.zoolatech.lecture3.tasks._4;

public class DocReporter extends AbstractReporter {
    public DocReporter(String header, String data, String name) {
        super(header, data, name);
    }

    public DocReporter(AbstractReporter reporter) {
        super(reporter);
    }

    @Override
    protected void convert() {
        System.out.println("File successfully convert to DOC format");
    }
}
