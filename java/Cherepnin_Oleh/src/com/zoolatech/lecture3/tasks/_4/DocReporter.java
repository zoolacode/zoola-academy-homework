package com.zoolatech.lecture3.tasks._4;

public final class DocReporter extends AbstractReporter {
    public DocReporter(String header, String data, String name) {
        super(header, data, name);
    }

    public DocReporter(AbstractReporter reporter) {
        super(reporter);
    }

    @Override
    protected void addName() {
        super.addName();
        System.out.println(".doc\"");
    }

    @Override
    protected void addHeader() {
        super.addHeader();
        System.out.println("doc format");
    }

    @Override
    protected void addData() {
        super.addData();
        System.out.println("doc format");
    }

    @Override
    protected void closeFile() {
        System.out.print("File:\"" + name + ".doc\" ");
        super.closeFile();
    }
}