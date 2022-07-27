package com.zoolatech.lecture4.tasks._1;

public class Container {
    private int value;

    public Container(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    class ContainerUpdatesListener {
        private final int startedValue;

        public ContainerUpdatesListener() {
            this.startedValue = value;
        }

        public boolean hasValueChanged() {
            return startedValue != value;
        }
    }
}
