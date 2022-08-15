package com.zoolatech.lecture3.tasks._4;

public abstract sealed class AbstractReporter permits DocReporter, PdfReporter, CvReporter {
    protected String header;
    protected String data;
    protected String name;

    public AbstractReporter(String header, String data, String name) {
        this.header = header;
        this.data = data;
        this.name = name;
    }

    public AbstractReporter(AbstractReporter reporter) {
        this(reporter.getHeader(), reporter.getData(), reporter.getName());
    }

    public void generate() {
        addName();
        addHeader();
        addData();
        closeFile();
    }

    protected void addName() {
        System.out.print("Creating a file: \"" + name);
    }

    protected void addHeader() {
        System.out.print("Adding header: \"" + header + "\" in ");
    }

    protected void addData() {
        System.out.print("Adding file data: \"" + data + "\" in ");
    }

    protected void closeFile() {
        System.out.println("successfully created and closed");
    }

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
