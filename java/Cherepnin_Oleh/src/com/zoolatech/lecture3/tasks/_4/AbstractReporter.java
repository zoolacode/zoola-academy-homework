package com.zoolatech.lecture3.tasks._4;

public abstract class AbstractReporter {
    private String header;
    private String data;
    private String name;

    public AbstractReporter(String header, String data, String name) {
        this.header = header;
        this.data = data;
        this.name = name;
    }

    public AbstractReporter(AbstractReporter reporter) {
        this(reporter.getHeader(), reporter.getData(), reporter.getName());
    }

    public void generate() {
        System.out.println("Opening a file: " + name +
                "\nAdd header:" + header +
                "\nAdd data:" + data);
        convert();
    }

    protected abstract void convert();

    public String getHeader() {
        return header;
    }

    public String getData() {
        return data;
    }

    public String getName() {
        return name;
    }
}
