package com.zoolatech.lecture4.tasks._1;

public class Container {
    String value;

    public Container(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public class ContainerUpdatesListener {
        String innerValue;

        public ContainerUpdatesListener() {
            this.innerValue = value;
        }

        boolean hasValueChanged() {
            return !innerValue.equals(value);
        }
    }
}
