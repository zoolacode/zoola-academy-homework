package com.zoolatech.lecture3.tasks._4;

public final class PdfReporter extends AbstractReporter {
    public PdfReporter(String header, String data, String name) {
        super(header, data, name);
    }

    public PdfReporter(AbstractReporter reporter) {
        super(reporter);
    }

    @Override
    protected void addName() {
        super.addName();
        System.out.println(".pdf\"");
    }

    @Override
    protected void addHeader() {
        super.addHeader();
        System.out.println("pdf file");
    }

    @Override
    protected void addData() {
        super.addData();
        System.out.println("pdf file");
    }

    @Override
    protected void closeFile() {
        System.out.print("File:\"" + name + ".pdf\" ");
        super.closeFile();
    }
}
