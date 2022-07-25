package com.zoolatech.lecture3.tasks._4;

public class PdfReporter extends AbstractReporter {
    public PdfReporter(String header, String data, String name) {
        super(header, data, name);
    }

    public PdfReporter(AbstractReporter reporter) {
        super(reporter);
    }

    @Override
    protected void convert() {
        System.out.println("File successfully convert to Pdf format");
    }
}
