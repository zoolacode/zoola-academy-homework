package com.zoolatech.lecture4.tasks._1;

public class Container {
    private String value;

    public Container(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    class ContainerUpdatesListener {
        private final String innerValue;

        public ContainerUpdatesListener() {
            this.innerValue = value;
        }

        boolean hasValueChanged() {
            if (value == null)
                return false;
            return !innerValue.equals(value);
        }
    }
}
