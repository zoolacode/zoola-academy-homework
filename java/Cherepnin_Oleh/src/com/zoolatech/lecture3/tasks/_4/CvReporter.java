package com.zoolatech.lecture3.tasks._4;

public final class CvReporter extends AbstractReporter {

    public CvReporter(String header, String data, String name) {
        super(header, data, name);
    }

    public CvReporter(AbstractReporter reporter) {
        super(reporter);
    }

    @Override
    protected void addName() {
        super.addName();
        System.out.println(".cv\"");
    }

    @Override
    protected void addHeader() {
        super.addHeader();
        System.out.println("cv file");
    }

    @Override
    protected void addData() {
        super.addData();
        System.out.println("cv file");
    }

    @Override
    protected void closeFile() {
        System.out.print("File:\"" + name + ".cv\" ");
        super.closeFile();
    }
}
